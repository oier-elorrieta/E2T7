package bd_Konexioa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BD_Konexioa {
	private static final String URL = "jdbc:mysql://localhost:3307/db_progprueba";
	private static final String USER = "root";
	private static final String PASSWORD = "";
	private Connection connection;

	public void connect() {
		try {
			if (connection == null || connection.isClosed()) {
				connection = DriverManager.getConnection(URL, USER, PASSWORD);
				System.out.println("Konexio Egokia Datu Basearekin.");
			}
		} catch (SQLException e) {
			System.err.println("Errorea Datu Basearekin Konektatzean: " + e.getMessage());
		}
	}

	public void disconnect() {
		try {
			if (connection != null && !connection.isClosed()) {
				connection.close();
				System.out.println("Konexioa Itxita Modu Egokian.");
			}
		} catch (SQLException e) {
			System.err.println("Errorea Konexioa Ixtean: " + e.getMessage());
		}
	}
}
