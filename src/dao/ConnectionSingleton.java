package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionSingleton {
	private static Connection connection;
	private static final String jdbcDriver = "com.mysql.cj.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost:3306/db_bijoux";
	private static final String user = "root";
	private static final String passwd = "@mbrE2002laverp";
	
	public static Connection getInstance() throws ClassNotFoundException, SQLException {
		if (connection == null || connection.isClosed()) {
			try {
				Class.forName(jdbcDriver);
				connection = DriverManager.getConnection(url, user, passwd);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return connection;
	}
}
