package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DatabaseCon {

	private static String driver = "org.apache.hive.jdbc.HiveDriver"; // driver used for hiveserver2

	private DatabaseCon() {
		// Private constructor
	}

	public static Connection connectDB() throws ClassNotFoundException, SQLException {

		Class.forName(driver);
		return DriverManager.getConnection("jdbc:hive2://localhost:10000/default", "", "");
	}
}
