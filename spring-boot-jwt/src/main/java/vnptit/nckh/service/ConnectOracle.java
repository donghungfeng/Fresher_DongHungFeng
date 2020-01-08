package vnptit.nckh.service;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectOracle {

	public static Connection getConnection() {
		Connection conn;
		try {
			String dbURL2 = "jdbc:oracle:thin:@10.145.21.100:1521/pdb_testl2";
            String username = "PM2_FRESHER";
            String password = "fresher2020";
            conn = DriverManager.getConnection(dbURL2, username, password);
	        if (conn != null) {
	            System.out.println("Connected with connection #1");
	        }
	        return conn;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
