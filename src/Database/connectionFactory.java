package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class connectionFactory {

	protected connectionFactory() {
		try {
			Class.forName(forName);
		} catch (ClassNotFoundException e) {
			System.out.println("DataBase forName Fails!");
			e.printStackTrace();
		}
	}

	private Connection createConnection() {

		try {
			conn = DriverManager.getConnection(hostAddress, userName, password);
		} catch (SQLException e) {
			System.out.println("DataBase Connection Fails");
			e.printStackTrace();
		}
		return conn;
	}

	public static Connection getConnection() {
		return instance.createConnection();
	}

	private static connectionFactory instance = new connectionFactory();
	private static Connection conn = null;
	private static final String userName = "root";
	private static final String password = "S@iFliT0N";
	private static final String forName = "com.mysql.jdbc.Driver";
	protected   String hostAddress = "jdbc:mysql://localhost/";

}
