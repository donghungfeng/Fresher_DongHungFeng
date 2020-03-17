package com.api;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import Connection.ConnectSqlite;
import entities.Cashier;
import entities.LogConnect;


@Service
public class LogConnectService {
	
	//private static final Logger logger = (Logger) LoggerFactory.getLogger(CashierService.class);
	private List<LogConnect> result = new ArrayList<LogConnect>();
	private Connection con = ConnectSqlite.getConnection();
	
	private String SQL_GETALL = "SELECT * FROM LOG_CONNECT";
	private String SQL_GETBYID = "SELECT * FROM LOG_CONNECT WHERE id = ?";
	private String SQL_INSERT = "INSERT INTO LOG_CONNECT(type,createdate,sourceip,destinationip,metadata) VALUES(?,?,?,?,?)";
	private String SQL_UPDATE = "UPDATE LOG_CONNECT SET type = ?, createdate = ?, sourceip=?, destinationip = ?, metadata = ? WHERE id = ?";
	private String SQL_DELETE = "DELETE FROM LOG_CONNECT WHERE id = ?";
	
	public List<LogConnect> getAll()  {
		try {
			PreparedStatement stmt = con.prepareStatement(SQL_GETALL);
			ResultSet rs=stmt.executeQuery();
			result = new ArrayList<LogConnect>();
			while(rs.next()) {
				result.add(new LogConnect(rs.getInt("id"),rs.getString("type"),rs.getString("createdate"),rs.getString("sourceip"),rs.getString("destinationip"),rs.getString("metadata")));
			}
		} catch (Exception e) {
			
		}  	
		return result;
	}
	public LogConnect getById(int id) {
		LogConnect t = null;
		try {
			PreparedStatement stmt = con.prepareStatement(SQL_GETBYID);
			stmt.setInt(1, id);
			ResultSet rs=stmt.executeQuery();
			rs.next();
			t = new LogConnect(rs.getInt("id"),rs.getString("type"),rs.getString("createdate"),rs.getString("sourceip"),rs.getString("destinationip"),rs.getString("metadata"));
		} catch (Exception e) {
			e.printStackTrace();
		}  
		return t;
	}
	public int save (LogConnect logConnect) {
		if(logConnect.getType()==null || logConnect.getCreatedate()==null || logConnect.getSourceip()==null || logConnect.getDestinationip()==null)
			return 99;
		try {
			if(logConnect.getId()== 0) {
				PreparedStatement stmt = con.prepareStatement(SQL_INSERT);
				stmt.setString(1, logConnect.getType());
				stmt.setString(2, logConnect.getCreatedate());
				stmt.setString(3, logConnect.getSourceip());
				stmt.setString(4, logConnect.getDestinationip());
				stmt.setString(5, logConnect.getMetadata());
				stmt.executeUpdate();
			}
			else {
				PreparedStatement stmt = con.prepareStatement(SQL_UPDATE);
				stmt.setString(1, logConnect.getType());
				stmt.setString(2, logConnect.getCreatedate());
				stmt.setString(3, logConnect.getSourceip());
				stmt.setString(4, logConnect.getDestinationip());
				stmt.setString(5, logConnect.getMetadata());
				stmt.setInt(6, logConnect.getId());
				stmt.executeUpdate();
			}
			return 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			return 99;
		} 
	}
	public int delete(int id) {
		try {
			PreparedStatement stmt = con.prepareStatement(SQL_DELETE);
			stmt.setInt(1, id);
			stmt.executeUpdate();
			return 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return 99;
		} 
	}

}
