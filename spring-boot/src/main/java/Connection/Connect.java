package Connection;

import java.sql.Connection;

public class Connect {
	
	public Connection getConnection(String database) {
		if(database.equals("oracle"))
			return ConnectOracle.getConnection();
		else if(database.equals("sqlite"))
			return ConnectSqlite.getConnection();
		else
			return null;
				
	}

}
