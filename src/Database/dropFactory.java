package Database;

import java.sql.SQLException;

public class dropFactory {

	public static void dropDatabase(String databaseName) {
		try {
			connectionFactory.getConnection().createStatement().execute("DROP DATABASE IF EXISTS " + databaseName+" ;");
			System.out.println("Database Drop Successfully");
		} catch (SQLException e) {
			System.out.println("Database Drop Error");
			e.printStackTrace();
		} finally {
			DbUtil.close(connectionFactory.getConnection());
		}
	}

	public static void dropTable(String databaseName, String Name) {
		try {
			connectionFactory.getConnection().createStatement()
					.execute("DROP TABLE IF EXISTS " + databaseName + "." + Name + ";");
			System.out.println("Table Successfully Drop");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Table Drop Error");
		} finally {
			DbUtil.close(connectionFactory.getConnection());
		}
	}

}
