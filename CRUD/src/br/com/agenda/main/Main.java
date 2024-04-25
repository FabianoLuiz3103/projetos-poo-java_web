package br.com.agenda.main;

import java.util.Date;

import br.com.agenda.dao.ContatoDAO;
import br.com.agenda.model.Contato;

public class Main {

	public static void main(String[] args) {
		
		Contato contato = new Contato();
		contato.setNome("Fabiano Lu");
		contato.setIdade(20);
		contato.setDataCadastro(new Date());
		
		Contato contato2 = new Contato();
		contato2.setNome("Yolanda Bi");
		contato2.setIdade(16);
		contato2.setDataCadastro(new Date());
		
		Contato contato3 = new Contato();
		contato3.setNome("Luiz Fab");
		contato3.setIdade(20);
		contato3.setDataCadastro(new Date());
		
		ContatoDAO contatoDao = new ContatoDAO();
		//contatoDao.save(contato);
		//contatoDao.save(contato3);
		
		//Atualizar o contato
		Contato c = new Contato();
		c.setNome("Fabiano Luizao");
		c.setIdade(18);
		c.setDataCadastro(new Date());
		c.setId(1);
		//contatoDao.atualizaContato(c);
		
		contatoDao.deletarContatoById(1);
		contatoDao.deletarContatoById(2);
		contatoDao.deletarContatoById(3);
		contatoDao.deletarContatoById(4);
		contatoDao.deletarContatoById(5);
		contatoDao.deletarContatoById(6 );
		
		//Visualizar todos os registros
		for(Contato cont : contatoDao.listaContatos()) {
			System.out.println(cont.getNome());
		}

	}

}
