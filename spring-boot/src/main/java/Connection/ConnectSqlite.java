package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectSqlite {

	public ConnectSqlite() {
		// TODO Auto-generated constructor stub
	}
	public static Connection getConnection() {
		Connection conn = null;
		// db parameters
        String url = "jdbc:sqlite:C:/sqlite/PMM.db";
        // create a connection to the database
        try {
			conn = DriverManager.getConnection(url);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return conn;
	}

}
