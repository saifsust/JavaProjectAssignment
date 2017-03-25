package Database;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

public class metaDataFactory {

	public static boolean IsTable(String Name){
		boolean test = false;
		try {
			meta = connectionFactory.getConnection().getMetaData();
			result = meta.getTables(null, null, Name, null);
			test = result.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(connectionFactory.getConnection());
			DbUtil.close(result);
			}
		return test;
	}

	private static ResultSet result = null;
	private static  DatabaseMetaData meta;
}
