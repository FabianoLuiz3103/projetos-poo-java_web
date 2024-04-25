package br.com.fiap.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	static final String URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
	static final String USERNAME = "RM96044";
	static final String PASSWORD = "310303";
	
	public Connection conexao() throws ClassNotFoundException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//System.out.println("\n\bCONEX�O REALIZADA COM SUCESSO! ");
			return DriverManager.getConnection(URL, USERNAME, PASSWORD);
		}catch(SQLException e) {
			System.out.println("\n\bERRO AO CONECTAR!");
			throw new RuntimeException(e);
		}
	}

}
