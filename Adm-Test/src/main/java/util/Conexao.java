package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	private Connection connection = null;

	private static Conexao conexao;

	static {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private Conexao() {
		try {
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db_gestao_evento", "postgres",
					"1");
			new LoadTables().creatScherma(connection);
		} catch (SQLException e) {
			System.out.println("Erro ao conectar com o banco: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		return connection;
	}

	public static Conexao getConexao() {
		if (conexao == null) {
			conexao = new Conexao();
		}
		return conexao;
	}

	public void closeConnection() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
