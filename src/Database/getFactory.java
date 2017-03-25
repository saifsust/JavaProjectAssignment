package Database;

import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import saifulIslam.frameWorkForUser.Information;

public class getFactory {

	public static ObservableList<Information> getObservableListOfInformations(String databaseName) {

		list = FXCollections.observableArrayList();
		try {
			result = connectionFactory.getConnection().createStatement()
					.executeQuery("SELECT * FROM " + databaseName + ".informations ;");

			while (result.next()) {

				list.add(new Information(result.getString("RegNum"), result.getDouble("Marks"),
						result.getDouble("AverageCopy"), result.getInt("Solves")));
				// System.out.println(result.getString("RegNum"));F

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("ObsevableList Error");
		}

		return list;
	}

	private static ObservableList<Information> list;
	private static ResultSet result = null;

}
