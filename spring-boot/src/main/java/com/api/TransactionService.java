package com.api;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import Connection.ConnectSqlite;
import entities.Transaction;


@Service
public class TransactionService {
	
	private static final Logger logger = (Logger) LoggerFactory.getLogger(TransactionService.class);
	private List<Transaction> result = new ArrayList<Transaction>();
	private Connection con = ConnectSqlite.getConnection();
	
	private String SQL_GETALL = "SELECT * FROM TRANSACTION";
	private String SQL_GETBYID = "SELECT * FROM TRANSACTION WHERE transactionid = ?";
	private String SQL_INSERT = "INSERT INTO TRANSACTION(cashierid,posterminalid,amount,posrequestdate,posresponsedate,token,req_metadata,resp_metadata,resp_code,resp_message,status) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
	private String SQL_UPDATE = "UPDATE TRANSACTION SET cashierid = ?, posterminalid = ?, amount=?, posrequestdate = ?, posresponsedate = ?, req_metadata = ?, resp_metadata = ?, resp_code = ?, resp_message = ?, status = ? WHERE transactionid = ?";
	private String SQL_DELETE = "DELETE FROM TRANSACTION WHERE transactionid = ?";
	
	public List<Transaction> getAll()  {
		try {
			PreparedStatement stmt = con.prepareStatement(SQL_GETALL);
			ResultSet rs=stmt.executeQuery();
			result = new ArrayList<Transaction>();
			while(rs.next()) {
				result.add(new Transaction(rs.getInt("transactionid"),rs.getInt("cashierid"),rs.getInt("posterminalid"),rs.getString("amount"),rs.getString("posrequestdate"),rs.getString("posresponsedate"),rs.getString("token"),rs.getString("req_metadata"),rs.getString("resp_metadata"),rs.getString("resp_code"),rs.getString("resp_message"),rs.getInt("status")));
			}
		} catch (Exception e) {
			logger.error("TransactionService.getAll | " + e.getMessage());
		}  	
		return result;
	}
	public Transaction getById(int id) {
		Transaction t = null;
		try {
			PreparedStatement stmt = con.prepareStatement(SQL_GETBYID);
			stmt.setInt(1, id);
			ResultSet rs=stmt.executeQuery();
			rs.next();
			t = new Transaction(rs.getInt("transactionid"),rs.getInt("cashierid"),rs.getInt("posterminalid"),rs.getString("amount"),rs.getString("posrequestdate"),rs.getString("posresponsedate"),rs.getString("token"),rs.getString("req_metadata"),rs.getString("resp_metadata"),rs.getString("resp_code"),rs.getString("resp_message"),rs.getInt("status"));
		} catch (Exception e) {
			logger.error("TransactionService.getbyid | " + e.getMessage());
		}  
		return t;
	}
	public int save (Transaction transaction) {
		if(transaction.getCashierid()==0|| transaction.getPosterminalid()==0 || transaction.getAmount()==null||transaction.getPosrequestdate()==null||transaction.getPosresponsedate()==null||transaction.getResp_code()==null||transaction.getToken()==null) {
			logger.error("TransactionService.save |cashierid, posterminal, amount, posrequestdate, posresponsedate, resp_code,token not null");
			return 99;
		}
		try {
			if(transaction.getCashierid() == 0) {
				PreparedStatement stmt = con.prepareStatement(SQL_INSERT);
				stmt.setInt(1, transaction.getCashierid());
				stmt.setInt(2, transaction.getPosterminalid());
				stmt.setString(3, transaction.getAmount());
				stmt.setString(4, transaction.getPosrequestdate());
				stmt.setString(5, transaction.getPosresponsedate());
				stmt.setString(6, transaction.getToken());
				stmt.setString(7, transaction.getReq_metadata());
				stmt.setString(8, transaction.getResp_metadata());
				stmt.setString(9, transaction.getResp_code());
				stmt.setString(10, transaction.getResp_message());
				stmt.setInt(11, transaction.getStatus());
				stmt.executeUpdate();
			}
			else {
				PreparedStatement stmt = con.prepareStatement(SQL_UPDATE);
				stmt.setInt(1, transaction.getCashierid());
				stmt.setInt(2, transaction.getPosterminalid());
				stmt.setString(3, transaction.getAmount());
				stmt.setString(4, transaction.getPosrequestdate());
				stmt.setString(5, transaction.getPosresponsedate());
				stmt.setString(6, transaction.getToken());
				stmt.setString(7, transaction.getReq_metadata());
				stmt.setString(8, transaction.getResp_metadata());
				stmt.setString(9, transaction.getResp_code());
				stmt.setString(10, transaction.getResp_message());
				stmt.setInt(11, transaction.getStatus());
				stmt.setInt(12, transaction.getTransactionid());
				stmt.executeUpdate();
			}
			return 0;
		} catch (SQLException e) {
			logger.error("TransactionService.save | " + e.getMessage());
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
			logger.error("TransactionService.delete | " + e.getMessage());
			return 99;
		} 
	}

}
