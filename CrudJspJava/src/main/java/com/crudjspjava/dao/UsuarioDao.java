package com.crudjspjava.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.crudjspjava.bean.Usuario;

public class UsuarioDao {

	public static Connection getConnection() {
		
		Connection con = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL", "RM96044", "310303");
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	
	//LISTAGEM, SABER SE TEM OU NÃO USUÁRIO
	public static List<Usuario> listarUsuario(){
		
		List<Usuario> usuariosList = new ArrayList<>();
		String sql = "SELECT * FROM cad_usuario";
		
		try {
			Connection con = getConnection();
			PreparedStatement pstm = con.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(rs.getInt("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setPassword(rs.getString("password"));
				usuario.setEmail(rs.getString("email"));
				usuario.setSexo(rs.getString("sexo"));
				usuario.setPais(rs.getString("pais"));
				
				usuariosList.add(usuario);
			}
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		return usuariosList;
		
	}
	
	
	//Retornar dados do usuário que eu quero editar
	public static Usuario pegarById(int id) {
		
		Usuario usuario = null;
		String sql = "SELECT * FROM cad_usuario WHERE id = ? ";
		
		try {
			Connection con = getConnection();
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setInt(1, id);
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()) {
				
				usuario = new Usuario();
				usuario.setId(rs.getInt("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setPassword(rs.getString("password"));
				usuario.setEmail(rs.getString("email"));
				usuario.setSexo(rs.getString("sexo"));
				usuario.setPais(rs.getString("pais"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return usuario; 
	}
	
	
	//UPDATE
	public static int updateUsuario(Usuario u) {
		int status = 0;
		String sql = "UPDATE cad_usuario SET nome=?, "
				+ "password=?, email=?, sexo=?, pais=? WHERE id=? ";
		
		try {
			Connection con = getConnection();
			PreparedStatement pstm = con.prepareStatement(sql);
			
			pstm.setString(1, u.getNome());
			pstm.setString(2, u.getPassword());
			pstm.setString(3, u.getEmail());
			pstm.setString(4, u.getSexo());
			pstm.setString(5, u.getPais());
			pstm.setInt(6, u.getId());
			status = pstm.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return status;
	}
	
	//CREATE
	public static int salvarUsuario(Usuario u) {
		
		int status = 0;
		String sql = "INSERT INTO cad_usuario (nome, password, email, sexo, pais) VALUES (?, ?, ?, ?, ?)";
		
		try {
			Connection con = getConnection();
			PreparedStatement pstm = con.prepareStatement(sql);
			
			pstm.setString(1, u.getNome());
			pstm.setString(2, u.getPassword());
			pstm.setString(3, u.getEmail());
			pstm.setString(4, u.getSexo());
			pstm.setString(5, u.getPais());
			status = pstm.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return status;
	}
	
		
    //DELETE
	public static int deletarUsuario(Usuario u) {
		int status = 0;
		String sql = "DELETE FROM cad_usuario WHERE id = ?";
		
		try{
		
			Connection con = getConnection();
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setInt(1, u.getId());
			status = pstm.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	
	//Limitar quantidade de usuários por páginas
//	public static List<Usuario> getRegistros(int start, int total){
//		List<Usuario> list = new ArrayList<Usuario>();
//		
//		try {
//			Connection con = getConnection();
//			PreparedStatement pstm = con.prepareStatement("SELECT * FROM cad_usuario LIMIT "+(start)+","+total);
//			ResultSet rs = pstm.executeQuery();
//			
//			while(rs.next()) {
//				Usuario usuario = new Usuario();
//				usuario.setId(rs.getInt("id"));
//				usuario.setNome(rs.getString("nome"));
//				usuario.setPassword(rs.getString("password"));
//				usuario.setEmail(rs.getString("email"));
//				usuario.setSexo(rs.getString("sexo"));
//				usuario.setPais(rs.getString("pais"));
//				
//				list.add(usuario);
//			}
//			con.close();
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//		return list;
//	}
	}
