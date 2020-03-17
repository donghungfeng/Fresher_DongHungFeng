package com.api;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import Connection.ConnectSqlite;
import entities.Posterminal;


@Service
public class PosterminalService {
	
	private static final Logger logger = LoggerFactory.getLogger(PosterminalService.class);
	private List<Posterminal> result = new ArrayList<Posterminal>();
	private Connection con = ConnectSqlite.getConnection();
	
	private String SQL_GETALL = "SELECT * FROM POSTERMINAL WHERE NAME LIKE ?";
	private String SQL_GETBYID = "SELECT * FROM POSTERMINAL WHERE posterminalid = ?";
	private String SQL_INSERT = "INSERT INTO POSTERMINAL(code,name,ipaddress,status) VALUES(?,?,?,?)";
	private String SQL_UPDATE = "UPDATE POSTERMINAL SET code = ?, name = ?, ipaddress=?, status = ? WHERE posterminalid = ?";
	private String SQL_DELETE = "DELETE FROM POSTERMINAL WHERE posterminalid = ?";
	
	public List<Posterminal> getAll(String name)  {
		try {
			PreparedStatement stmt = con.prepareStatement(SQL_GETALL);
			stmt.setString(1, "%"+name+"%");
			ResultSet rs=stmt.executeQuery();
			result = new ArrayList<Posterminal>();
			while(rs.next()) {
				result.add(new Posterminal(rs.getInt("posterminalid"),rs.getString("code"),rs.getString("name"),rs.getString("ipaddress"),rs.getInt("status")));
			}
		} catch (Exception e) {
			logger.error("PosterminalService.getAll | " + e.getMessage());
		}  	
		return result;
	}
	public Posterminal getById(int id) {
		Posterminal t = null;
		try {
			PreparedStatement stmt = con.prepareStatement(SQL_GETBYID);
			stmt.setInt(1, id);
			ResultSet rs=stmt.executeQuery();
			rs.next();
			t = new Posterminal(rs.getInt("posterminalid"),rs.getString("code"),rs.getString("name"),rs.getString("ipaddress"),rs.getInt("status"));
		} catch (Exception e) {
			logger.error("PosterminalService.getbyid | " + e.getMessage());
		}  
		return t;
	}
	public int save (Posterminal posterminal) {
		if(posterminal.getName()==null || posterminal.getCode()==null || posterminal.getIpaddress()==null) {
			logger.error("PosterminalService.save | name,code,ipaddress not null");
			return 99;
		}
		try {
			if(posterminal.getPosterminalid() == 0) {
				PreparedStatement stmt = con.prepareStatement(SQL_INSERT);
				stmt.setString(1, posterminal.getCode());
				stmt.setString(2, posterminal.getName());
				stmt.setString(3, posterminal.getIpaddress());
				stmt.setInt(4, posterminal.getStatus());
				stmt.executeUpdate();
			}
			else {
				PreparedStatement stmt = con.prepareStatement(SQL_UPDATE);
				stmt.setString(1, posterminal.getCode());
				stmt.setString(2, posterminal.getName());
				stmt.setString(3, posterminal.getIpaddress());
				stmt.setInt(4, posterminal.getStatus());
				stmt.setInt(5, posterminal.getPosterminalid());
				stmt.executeUpdate();
			}
			return 0;
		} catch (SQLException e) {
			logger.error("PosterminalService.save | " + e.getMessage());
			return 99;
		} 
	}
	public int delete(Posterminal posterminal) {
		try {
			PreparedStatement stmt = con.prepareStatement(SQL_DELETE);
			stmt.setInt(1, posterminal.getPosterminalid());
			stmt.executeUpdate();
			return 0;
		} catch (SQLException e) {
			logger.error("PosterminalService.delete | " + e.getMessage());
			return 99;
		} 
	}

}
