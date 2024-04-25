package br.com.fiap.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fiap.bean.Postagem;
import br.com.fiap.bean.UsuarioRede;
import br.com.fiap.controller.PostagemController;
import br.com.fiap.controller.UsuarioRedeController;

/**
 * Servlet implementation class ProfileServlet
 */
@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Postagem> listaPorUsuario = new ArrayList<>();
		List<UsuarioRede> listaUsuarios = new ArrayList<>();
		PostagemController postagemDao = null;
		UsuarioRedeController usuarioDao = null;
		try {
			postagemDao = new PostagemController();
			usuarioDao = new UsuarioRedeController();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		HttpSession session = request.getSession();
		String idUsuario = (String) session.getAttribute("idUsuario");
		for(Postagem p: postagemDao.listarPorUsuario(idUsuario)) {
			listaPorUsuario.add(p);
		}
		for(UsuarioRede u : usuarioDao.listarTodos()) {
			listaUsuarios.add(u);
		}
		request.setAttribute("posts", listaPorUsuario);
		request.setAttribute("usuarios", listaUsuarios);
		request.getRequestDispatcher("profile.jsp").forward(request, response);
		
		postagemDao.encerrar();
		usuarioDao.encerrar();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
