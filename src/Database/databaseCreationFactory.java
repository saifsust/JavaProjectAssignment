package Database;

import java.sql.Connection;
import java.sql.SQLException;

public class databaseCreationFactory extends connectionFactory{
	private static void createDatabase(String databaseName)
	{
		 try {
			getConnection().createStatement().execute("CREATE DATABASE IF NOT EXISTS "+databaseName+";");
			System.out.println("Database Creation Is Successful");
		} catch (SQLException e) {
			System.out.println("Database Creation Is Failed");
			e.printStackTrace();
		}finally{
			DbUtil.close(getConnection());
		}

	}

	/**
	 * @return the databaseName
	 */
	public static String getDatabaseName() {
		return databaseName;
	}

	/**
	 * @param databaseName
	 *            the databaseName to set
	 */
	public static void setDatabaseName(String databaseName) {
		createDatabase(databaseName);
		databaseCreationFactory.databaseName = databaseName;
	}


	private static String databaseName = null;
}
