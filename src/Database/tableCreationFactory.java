package Database;

import java.sql.SQLException;

public class tableCreationFactory {
	public static final String userAccountTable ="system.user_account";

	public static void createUserAccountTable() {
		try {
			connectionFactory.getConnection().createStatement().execute("CREATE TABLE IF NOT EXISTS "+userAccountTable+"(ID INT(11) NOT NULL AUTO_INCREMENT,userName VARCHAR(255) NULL UNIQUE, password VARCHAR(255),PRIMARY KEY(ID));");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("User Account Error");
		} finally {

			DbUtil.close(connectionFactory.getConnection());
		}

	}

	public static void createInformationTable(String databaseName) {
		try {
			connectionFactory.getConnection().createStatement().execute("CREATE TABLE IF NOT EXISTS " + databaseName
					+ ".informations ( RegNum VARCHAR(255),AverageCopy FLOAT,Solves INT(11),Marks FLOAT, PRIMARY KEY(RegNum));");
			System.out.println("Information Table Create Successfully");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Information Table Creation Error");
		} finally {
			DbUtil.close(connectionFactory.getConnection());
		}
	}

	public static void createIndividualDataTable(String databaseName, String Name) {
		try {
			connectionFactory.getConnection().createStatement().execute("CREATE TABLE IF NOT EXISTS " + databaseName
					+ "." + Name
					+ "( ID INT(11) NOT NULL AUTO_INCREMENT,copyTableName VARCHAR(255),Questions VARCHAR(255) UNIQUE,maximumCopy FLOAT,PRIMARY KEY(ID));");
			System.out.println("Individual Table CREATE Successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(connectionFactory.getConnection());
		}

	}

	public static void createPercentageOfCopyTable(String databaseName, String Name) {
		String query = "CREATE TABLE IF NOT EXISTS " + databaseName + "." + Name
				+ "( RegNum VARCHAR(255) NULL ,percentageOfCopy FLOAT NULL,PRIMARY KEY(RegNum) );";
		try {
			connectionFactory.getConnection().createStatement().execute(query);
			System.out.println("Table Create Successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(connectionFactory.getConnection());
		}
	}
}
