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


@Service
public class CashierService {
	
	//private static final Logger logger = (Logger) LoggerFactory.getLogger(CashierService.class);
	private List<Cashier> result = new ArrayList<Cashier>();
	private Connection con = ConnectSqlite.getConnection();
	
	private String SQL_GETALL = "SELECT * FROM CASHIER WHERE NAME LIKE ?";
	private String SQL_GETBYID = "SELECT * FROM CASHIER WHERE cashierid = ?";
	private String SQL_INSERT = "INSERT INTO CASHIER(code,name,ipaddress,status) VALUES(?,?,?,?)";
	private String SQL_UPDATE = "UPDATE CASHIER SET code = ?, name = ?, ipaddress=?, status = ? WHERE cashierid = ?";
	private String SQL_DELETE = "DELETE FROM CASHIER WHERE cashierid = ?";
	
	public List<Cashier> getAll(String name)  {
		try {
			PreparedStatement stmt = con.prepareStatement(SQL_GETALL);
			stmt.setString(1, "%"+name+"%");
			ResultSet rs=stmt.executeQuery();
			result = new ArrayList<Cashier>();
			while(rs.next()) {
				result.add(new Cashier(rs.getInt("cashierid"),rs.getString("code"),rs.getString("name"),rs.getString("ipaddress"),rs.getInt("status")));
			}
		} catch (Exception e) {
			
		}  	
		return result;
	}
	public Cashier getById(int id) {
		Cashier t = null;
		try {
			PreparedStatement stmt = con.prepareStatement(SQL_GETBYID);
			stmt.setInt(1, id);
			ResultSet rs=stmt.executeQuery();
			rs.next();
			t = new Cashier(rs.getInt("cashierid"),rs.getString("code"),rs.getString("name"),rs.getString("ipaddress"),rs.getInt("status"));
		} catch (Exception e) {
			e.printStackTrace();
		}  
		return t;
	}
	public int save (Cashier cashier) {
		if(cashier.getName()==null || cashier.getCode()==null || cashier.getCode()==null)
			return 99;
		try {
			if(cashier.getCashierid() == 0) {
				PreparedStatement stmt = con.prepareStatement(SQL_INSERT);
				stmt.setString(1, cashier.getCode());
				stmt.setString(2, cashier.getName());
				stmt.setString(3, cashier.getIpaddress());
				stmt.setInt(4, cashier.getStatus());
				stmt.executeUpdate();
			}
			else {
				PreparedStatement stmt = con.prepareStatement(SQL_UPDATE);
				stmt.setString(1, cashier.getCode());
				stmt.setString(2, cashier.getName());
				stmt.setString(3, cashier.getIpaddress());
				stmt.setInt(4, cashier.getStatus());
				stmt.setInt(5, cashier.getCashierid());
				stmt.executeUpdate();
			}
			return 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			return 99;
		} 
	}
	public int delete(Cashier cashier) {
		try {
			PreparedStatement stmt = con.prepareStatement(SQL_DELETE);
			stmt.setInt(1, cashier.getCashierid());
			stmt.executeUpdate();
			return 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			return 99;
		} 
	}

}
