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
import entities.CashierPosterminal;


@Service
public class CashierPosterminalService {
	
	private static final Logger logger = (Logger) LoggerFactory.getLogger(CashierPosterminalService.class);
	private List<CashierPosterminal> result = new ArrayList<CashierPosterminal>();
	private Connection con = ConnectSqlite.getConnection();
	
	private String SQL_GETALL = "SELECT * FROM CASHIER_POSTERMINAL";
	private String SQL_GETBYCASHIERID = "SELECT * FROM CASHIER_POSTERMINAL WHERE cashierid = ?";
	private String SQL_GETBYPOSTERMINALID = "SELECT * FROM CASHIER_POSTERMINAL WHERE posterminalid = ?";
	private String SQL_INSERT = "INSERT INTO CASHIER_POSTERMINAL(cashierid,posterminalid) VALUES(?,?)";
	private String SQL_DELETE = "DELETE FROM CASHIER WHERE cashierid = ? AND posterminalid = ?";
	
	public List<CashierPosterminal> getAll()  {
		try {
			PreparedStatement stmt = con.prepareStatement(SQL_GETALL);
			ResultSet rs=stmt.executeQuery();
			result = new ArrayList<CashierPosterminal>();
			while(rs.next()) {
				result.add(new CashierPosterminal(rs.getInt("cashierid"),rs.getInt("posterminalid")));
			}
		} catch (Exception e) {
			logger.error("CashierPosterminalService.getAll | " + e.getMessage());
		}  	
		return result;
	}
	public List<CashierPosterminal> getByCashierid(CashierPosterminal cashier)  {
		try {
			PreparedStatement stmt = con.prepareStatement(SQL_GETBYCASHIERID);
			stmt.setInt(1, cashier.getCashierid());
			ResultSet rs=stmt.executeQuery();
			result = new ArrayList<CashierPosterminal>();
			while(rs.next()) {
				result.add(new CashierPosterminal(rs.getInt("cashierid"),rs.getInt("posterminalid")));
			}
		} catch (Exception e) {
			logger.error("CashierPosterminalService.getByCashierid | " + e.getMessage());
		}  	
		return result;
	}
	public List<CashierPosterminal> getByPosterminalid(CashierPosterminal cashier)  {
		try {
			PreparedStatement stmt = con.prepareStatement(SQL_GETBYPOSTERMINALID);
			stmt.setInt(1, cashier.getPosterminalid());
			ResultSet rs=stmt.executeQuery();
			result = new ArrayList<CashierPosterminal>();
			while(rs.next()) {
				result.add(new CashierPosterminal(rs.getInt("cashierid"),rs.getInt("posterminalid")));
			}
		} catch (Exception e) {
			logger.error("CashierPosterminalService.getByPosterminalid | " + e.getMessage());
		}  	
		return result;
	}
	
	public int save (CashierPosterminal cashier) {
		if(cashier.getCashierid()==0 || cashier.getPosterminalid()==0) {
			logger.error("CashierPosterminalService.save | cashierid, posterminalid not null");
			return 99;
		}
		try {
			
			PreparedStatement stmt = con.prepareStatement(SQL_INSERT);
			stmt.setInt(1, cashier.getCashierid());
			stmt.setInt(2, cashier.getPosterminalid());
			stmt.executeUpdate();
			
			return 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error("CashierPosterminalService.save | " + e.getMessage());
			return 99;
		} 
	}
	public int delete (CashierPosterminal cashier) {
		try {
			
			PreparedStatement stmt = con.prepareStatement(SQL_DELETE);
			stmt.setInt(1, cashier.getCashierid());
			stmt.setInt(2, cashier.getPosterminalid());
			stmt.executeUpdate();
			
			return 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error("CashierPosterminalService.getAll | " + e.getMessage());
			return 99;
		} 
	}
	

}
