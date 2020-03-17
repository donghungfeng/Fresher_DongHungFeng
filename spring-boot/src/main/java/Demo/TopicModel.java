package Demo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import Connection.ConnectOracle;
import Connection.ConnectSqlite;


@Service
public class TopicModel {
	
	private List<Topic> result = new ArrayList<Topic>();
	private Connection con = ConnectOracle.getConnection();
	private String db = "oracle";
	
	public TopicModel(String db) {
		setDb(db);
		if(db.equals("oracle"))	
			con = ConnectOracle.getConnection();
		else if(db.equals("sqlite"))
			con = ConnectSqlite.getConnection();
		
	}
	
	public void setDb(String db) {
		this.db = db;
	}
	
	public String getDb() {
		return this.db;
	}
	
	public TopicModel() {
		
	}
	
	public List<Topic> getAllTopics(String name)  {
		try {
			Statement stmt=con.createStatement();
			String sql = "";
			if(getDb().equals("oracle"))
				sql = "select * from DONGHUNG.topic WHERE name like '%"+name+"%'";
			else
				sql = "select * from topic WHERE name like '%"+name+"%'";	
			ResultSet rs=stmt.executeQuery(sql);
			result = new ArrayList<Topic>();
			while(rs.next()) {
				result.add(new Topic(rs.getString("id"),rs.getString("name"),rs.getString("description"),rs.getInt("groupid")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}  	
		return result;
	}
	public List<Topic> getAllTopicByGroupId(int id)  {
		try {
			Statement stmt=con.createStatement();
			String sql = "select * from topic WHERE groupid = "+id;
			ResultSet rs=stmt.executeQuery(sql);
			result = new ArrayList<Topic>();
			while(rs.next()) {
				result.add(new Topic(rs.getString("id"),rs.getString("name"),rs.getString("description"),rs.getInt("groupid")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}  	
		return result;
	}
	public Topic getTopic(String id) {
		Topic t = null;
		try {
			Statement stmt=con.createStatement();
			String sql = "select * from topic WHERE id = '"+id+"'";
			ResultSet rs=stmt.executeQuery(sql);
			rs.next();
			t = new Topic(rs.getString("id"),rs.getString("name"),rs.getString("description"),rs.getInt("groupid"));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
		return t;
	}
	public String addTopic (Topic topic) {
		try {
			Statement stmt=con.createStatement();
			String sql = "INSERT INTO TOPIC(id,name,description,groupid) VALUES('"+topic.getId()+"','"+topic.getName()+"','"+topic.getDescription()+"',"+topic.getGroupid()+")";
			stmt.execute(sql);
			return "Add success";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return e.toString();
		} 
	}
	public void updateTopic(Topic topic) {
		try {
			Statement stmt=con.createStatement();
			String sql = "UPDATE TOPIC SET name = '"+topic.getName()+"',description = '"+topic.getDescription()+"', groupid = "+topic.getGroupid()+" WHERE id = '"+topic.getId()+"'";
			stmt.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	public void deleteTopic(String id) {
		try {
			Statement stmt=con.createStatement();
			String sql = "DELETE FROM TOPIC WHERE id = '"+id+"'";
			stmt.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}
