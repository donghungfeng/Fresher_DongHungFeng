package com.api;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.springframework.stereotype.Component;


@Component
public class ConnectOracle {
	public static Connection getConnection () {
		 try{  
			 //step1 load the driver class  
			 Class.forName("oracle.jdbc.driver.OracleDriver");  
			   
			 //step2 create  the connection object  
			 Connection con=DriverManager.getConnection(  
			 "jdbc:oracle:thin:@localhost:1521:xe","system","donghung");  
			   
			 return con;
			   
			 }catch(Exception e){ 
				
				 System.out.println(e);
				 return null;
			 	
			 }  
	}
}
