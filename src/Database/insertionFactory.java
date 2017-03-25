package Database;

import java.sql.SQLException;

public class insertionFactory {

	public static void insertInformation(String databaseName, String RegNum, double averageCopy, int solves,
			double Marks) {
		try {
			connectionFactory.getConnection().createStatement()
					.executeUpdate("INSERT INTO " + databaseName + ".informations "
							+ "( RegNum,AverageCopy,Solves,Marks ) VALUES ( " + RegNum + "," + averageCopy + ","
							+ solves + "," + Marks + " );");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Information Insertion Error");
		} finally {
			DbUtil.close(connectionFactory.getConnection());
		}

	}

	public static void insertIndividualData(String databaseName, String tableName, String Name, String Quest,
			double copy) {
		try {
			connectionFactory.getConnection().createStatement()
					.executeUpdate("INSERT INTO " + databaseName + "." + tableName
							+ "(copyTableName,Questions,maximumCopy) VALUES(  " + "'" + Name + "'" + "," + "'" + Quest
							+ "'" + "," + copy + " );");
			System.out.println("Individual Data Insert succesfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Individual data Insertion Error");
		} finally {
			DbUtil.close(connectionFactory.getConnection());
		}
	}

	public static void insertPercentageOfCopy(String databaseName, String tableName, String RegNum, double copy) {
		try {
			connectionFactory.getConnection().createStatement().executeUpdate("INSERT INTO " + databaseName + "."
					+ tableName + "(RegNum,percentageOfCopy) values(" + "'" + RegNum + "'" + "," + copy + ");");
			System.out.println("insert Successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(connectionFactory.getConnection());
		}

	}
}
