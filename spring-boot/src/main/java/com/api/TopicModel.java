package com.api;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicModel {
	
	private List<Topic> result = new ArrayList<Topic>();
	private Connection con=ConnectOracle.getConnection(); 
	
	public List<Topic> getAllTopics()  {
		try {
			Statement stmt=con.createStatement();
			String sql = "select * from DONGHUNG.topic";
			ResultSet rs=stmt.executeQuery(sql);
			result = new ArrayList<Topic>();
			while(rs.next()) {
				result.add(new Topic(rs.getString("id"),rs.getString("name"),rs.getString("description")));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
			
		return result;
	}
	public Topic getTopic(String id) {
		Topic t = null;
		try {
			Statement stmt=con.createStatement();
			String sql = "select * from DONGHUNG.topic WHERE id = '"+id+"'";
			ResultSet rs=stmt.executeQuery(sql);
			rs.next();
			t = new Topic(rs.getString("id"),rs.getString("name"),rs.getString("description"));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
		return t;
	}
	public void addTopic (Topic topic) {
		try {
			Statement stmt=con.createStatement();
			String sql = "INSERT INTO DONGHUNG.TOPIC(id,name,description) VALUES('"+topic.getId()+"','"+topic.getName()+"','"+topic.getDescription()+"')";
			stmt.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	public void updateTopic(Topic topic) {
		try {
			Statement stmt=con.createStatement();
			String sql = "UPDATE DONGHUNG.TOPIC SET name = '"+topic.getName()+"',description = '"+topic.getDescription()+"' WHERE id = '"+topic.getId()+"'";
			stmt.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	public void deleteTopic(String id) {
		try {
			Statement stmt=con.createStatement();
			String sql = "DELETE FROM DONGHUNG.TOPIC WHERE id = '"+id+"'";
			stmt.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}
