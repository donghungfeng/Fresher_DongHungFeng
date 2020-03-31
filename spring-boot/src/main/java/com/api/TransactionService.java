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
	private String SQL_GETBYID = "SELECT * FROM TRANSACTION WHERE requestid = ?";
	private String SQL_INSERT = "INSERT INTO TRANSACTION(requestid,transtype,cardno,amount,stan,time,expiredate,refno,approvalcode,returncode,tid,mid,currencycode,batchno,receiptno,cardtype,cardholder,cardinput,emvappname,emvaid,emvtc,posserial,transname,transstatus,clientid) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private String SQL_UPDATE = "UPDATE TRANSACTION SET transtype = ?, cardno = ?, amount=?, stan = ?, time = ?, expiredate = ?, refno = ?, approvalcode = ?, returncode = ?, tid = ?, mid = ?, currencycode = ?, batchno = ?, receiptno = ?, cardtype = ?, cardholder = ?, cardinput = ?, emvappname = ?, emvaid = ?, emvtc = ?, posserial = ?, transname = ?, transstatus = ?, clientid = ? WHERE requestid = ?";
	private String SQL_DELETE = "DELETE FROM TRANSACTION WHERE requestid = ?";
	
	public List<Transaction> getAll()  {
		try {
			PreparedStatement stmt = con.prepareStatement(SQL_GETALL);
			ResultSet rs=stmt.executeQuery();
			result = new ArrayList<Transaction>();
			while(rs.next()) {
				result.add(new Transaction(rs.getInt("requestid"),rs.getString("transtype"),rs.getString("cardno"),rs.getString("amount"),rs.getString("stan"),rs.getString("time"),rs.getString("expiredate"),rs.getString("refno"),rs.getString("approvalcode"),rs.getString("returncode"),rs.getString("tid"),rs.getString("mid"),rs.getString("currencycode"),rs.getString("batchno"),rs.getString("receiptno"),rs.getString("cardtype"),rs.getString("cardholder"),rs.getString("cardinput"),rs.getString("emvappname"),rs.getString("emvaid"),rs.getString("emvtc"),rs.getString("posserial"),rs.getString("transname"),rs.getString("transstatus"),rs.getString("clientid")));
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
			t = new Transaction(rs.getInt("requestid"),rs.getString("transtype"),rs.getString("cardno"),rs.getString("amount"),rs.getString("stan"),rs.getString("time"),rs.getString("expiredate"),rs.getString("refno"),rs.getString("approvalcode"),rs.getString("returncode"),rs.getString("tid"),rs.getString("mid"),rs.getString("currencycode"),rs.getString("batchno"),rs.getString("receiptno"),rs.getString("cardtype"),rs.getString("cardholder"),rs.getString("cardinput"),rs.getString("emvappname"),rs.getString("emvaid"),rs.getString("emvtc"),rs.getString("posserial"),rs.getString("transname"),rs.getString("transstatus"),rs.getString("clientid"));
		} catch (Exception e) {
			logger.error("TransactionService.getbyid | " + e.getMessage());
		}  
		return t;
	}
	public int save (Transaction transaction) {
		if(transaction.getAmount()==null) {
			logger.error("TransactionService.save |Not null");
			return 99;
		}
		try {
			if(transaction.getRequestid() == 0) {
				PreparedStatement stmt = con.prepareStatement(SQL_INSERT);
				stmt.setInt(1, transaction.getRequestid());
				stmt.setString(2, transaction.getTranstype());
				stmt.setString(3, transaction.getCardno());
				stmt.setString(4, transaction.getAmount());
				stmt.setString(5, transaction.getStan());
				stmt.setString(6, transaction.getTime());
				stmt.setString(7, transaction.getExpiredate());
				stmt.setString(8, transaction.getRefno());
				stmt.setString(9, transaction.getApprovalcode());
				stmt.setString(10, transaction.getReturncode());
				stmt.setString(11, transaction.getTid());
				stmt.setString(12, transaction.getMid());
				stmt.setString(13, transaction.getCurrencycode());
				stmt.setString(14, transaction.getBatchno());
				stmt.setString(15, transaction.getReceiptno());
				stmt.setString(16, transaction.getCardtype());
				stmt.setString(17, transaction.getCardholder());
				stmt.setString(18, transaction.getCardinput());
				stmt.setString(19, transaction.getEmvappname());
				stmt.setString(20, transaction.getEmvaid());
				stmt.setString(21, transaction.getEmvtc());
				stmt.setString(22, transaction.getPosserial());
				stmt.setString(23, transaction.getTransname());
				stmt.setString(24, transaction.getTransstatus());
				stmt.setString(25, transaction.getClientid());
				
				stmt.executeUpdate();
			}
			else {
				PreparedStatement stmt = con.prepareStatement(SQL_UPDATE);
				stmt.setString(1, transaction.getTranstype());
				stmt.setString(2, transaction.getCardno());
				stmt.setString(3, transaction.getAmount());
				stmt.setString(4, transaction.getStan());
				stmt.setString(5, transaction.getTime());
				stmt.setString(6, transaction.getExpiredate());
				stmt.setString(7, transaction.getRefno());
				stmt.setString(8, transaction.getApprovalcode());
				stmt.setString(9, transaction.getReturncode());
				stmt.setString(10, transaction.getTid());
				stmt.setString(11, transaction.getMid());
				stmt.setString(12, transaction.getCurrencycode());
				stmt.setString(13, transaction.getBatchno());
				stmt.setString(14, transaction.getReceiptno());
				stmt.setString(15, transaction.getCardtype());
				stmt.setString(16, transaction.getCardholder());
				stmt.setString(17, transaction.getCardinput());
				stmt.setString(18, transaction.getEmvappname());
				stmt.setString(19, transaction.getEmvaid());
				stmt.setString(20, transaction.getEmvtc());
				stmt.setString(21, transaction.getPosserial());
				stmt.setString(22, transaction.getTransname());
				stmt.setString(23, transaction.getTransstatus());
				stmt.setString(24, transaction.getClientid());
				
				stmt.setInt(25, transaction.getRequestid());
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
