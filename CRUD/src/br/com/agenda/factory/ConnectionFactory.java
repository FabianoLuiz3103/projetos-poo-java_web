package br.com.agenda.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	//Nome do usuário sql developer
	private static final String USERNAME = "RM96044";
	
	//Senha do banco
	private static final String PASSWORD = "310303";
	
	//Caminho, porta e nome do banco
	private static final String DATABASE_URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";

	//Conexão com o banco de dados
	public static Connection createrConnectionToSqlDeveloper() throws Exception {
		
		 // Carrega o driver JDBC do Oracle
        Class.forName("oracle.jdbc.driver.OracleDriver");
		
		//Cria a conexão com o banco de dados
		try {
			System.out.println("Conectado");
			return DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			System.out.println("Erro ao conectar");
			throw new RuntimeException(e);
		}
		
	}
	
}
