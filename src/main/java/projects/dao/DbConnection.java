package projects.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import projects.exception.DbException;

public class DbConnection {

	private static final String SCHEMA = "projects";
	private static final String USER = "projects";
	private static final String PASSWORD = "password";
	private static final String HOST = "localhost";
	private static final int PORT = 3306;

	public static Connection getConnection() {
		String url = String.format("jdbc:mysql://%s:%d/%s?user=%s&password=%s&useSSL=false", HOST, PORT, SCHEMA, USER,
				PASSWORD);

		try {
			Connection conn = DriverManager.getConnection(url);
			System.out.println("Connection to schema '" + SCHEMA + "' is successful.");
			return conn;
		} catch (SQLException e) {
			System.out.println("Unable to get connection at " + url);
			throw new DbException("Unable to get connection at \" + url");
		}

	}
}
