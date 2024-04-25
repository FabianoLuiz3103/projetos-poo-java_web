package br.com.agenda.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.agenda.factory.ConnectionFactory;
import br.com.agenda.model.Contato;

public class ContatoDAO {

	/*
	 * CRUD c: CREATE r: READ u: UPDATE d: DELETE
	 */

	//CREATE
	public void save(Contato contato) {

		String sql = "INSERT INTO contatos (nome, idade, dataCadastro) VALUES (?, ?, ?)";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			// Criar uma conexão com o banco de dados
			conn = ConnectionFactory.createrConnectionToSqlDeveloper();

			// Criamos uma PreparedStatment para executar uma query
			pstm = conn.prepareStatement(sql);
			// Adicionar os valores que são esperados pela query
			pstm.setString(1, contato.getNome());
			pstm.setInt(2, contato.getIdade());
			pstm.setDate(3, new Date(contato.getDataCadastro().getTime()));

			// Executar a query
			pstm.execute();
			System.out.println("Contato salvo com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			// Fechar as conexões
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	//READ
	public List<Contato> listaContatos() {

		String sql = "SELECT * FROM contatos";

		List<Contato> contatos = new ArrayList<>();

		Connection conn = null;
		PreparedStatement pstm = null;
		// Classe que vai recuperar os dados do banco
		ResultSet rst = null;

		try {
			conn = ConnectionFactory.createrConnectionToSqlDeveloper();

			// Executa o comando SQL
			pstm = conn.prepareStatement(sql);

			// Receber os dados do banco
			// O result é como se fosse um array
			rst = pstm.executeQuery();

			while (rst.next()) {// olha o próximo
				// enquanto houver registros no result ele vai percorrer

				Contato contato = new Contato(); // Cada contato que voltar do banco vai ter uma instância

				// Recuperar o id
				contato.setId(rst.getInt("id"));

				// Recuperar nome
				contato.setNome(rst.getString("nome"));

				// Recuperar idade
				contato.setIdade(rst.getInt("idade"));

				// Recuperar data
				contato.setDataCadastro(rst.getDate("dataCadastro"));

				contatos.add(contato);

			}
			// return contatos;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rst != null) {
					rst.close();
				}
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return contatos;
	}
	
	//UPDATE
	public void atualizaContato(Contato contato) {
		
		String sql = "UPDATE contatos SET nome = ?, idade = ?, dataCadastro = ? "
				+ "WHERE id = ? ";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			//Criar conexão com banco
			conn = ConnectionFactory.createrConnectionToSqlDeveloper();
			
			//Criar a classe para executar a query
			pstm = conn.prepareStatement(sql);
			
			//Adicionar os valores para atualizar
			pstm.setString(1, contato.getNome());
			pstm.setInt(2, contato.getIdade());
			pstm.setDate(3, new Date(contato.getDataCadastro().getTime()));
			
			//Qual o ID do registro que deseja atualizar
			pstm.setInt(4, contato.getId());
			
			//Executar a query
			pstm.execute();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
			try {
				
				if(pstm != null) {
					
					pstm.close();
				}
				
				if(conn != null){
					conn.close();
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}	
	}
	
	//DELETE
	public void deletarContatoById(int id) {
		
		String sql = "DELETE FROM contatos WHERE id = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createrConnectionToSqlDeveloper();
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, id);
			
			pstm.execute();
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}finally {
			
			try {
				if(pstm != null) {
					pstm.close();
				}
				
				if(conn != null) {
					pstm.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
}


    