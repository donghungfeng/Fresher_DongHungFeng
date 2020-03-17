package Demo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import Connection.ConnectSqlite;


@Service
public class GroupTopicModel {
	
	private List<GroupTopic> result = new ArrayList<GroupTopic>();
	private Connection con=ConnectSqlite.getConnection(); 
	
	public List<GroupTopic> getAllGroupTopics()  {
		try {
			Statement stmt=con.createStatement();
			String sql = "select * from grouptopic";
			ResultSet rs=stmt.executeQuery(sql);
			result = new ArrayList<GroupTopic>();
			while(rs.next()) {
				result.add(new GroupTopic(rs.getInt("grouptopicid"),rs.getString("name"),rs.getString("description")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}  	
		return result;
	}
	public GroupTopic getGroupTopic(int id) {
		GroupTopic t = null;
		try {
			Statement stmt=con.createStatement();
			String sql = "select * from GROUPTOPIC WHERE grouptopicid = "+id+"";
			ResultSet rs=stmt.executeQuery(sql);
			rs.next();
			t = new GroupTopic(rs.getInt("grouptopicid"),rs.getString("name"),rs.getString("description"));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
		return t;
	}
	public void addGroupTopic (GroupTopic grouptopic) {
		try {
			Statement stmt=con.createStatement();
			String sql = "INSERT INTO GROUPTOPIC(grouptopicid,name,description,groupid) VALUES("+grouptopic.getGrouptopicid()+",'"+grouptopic.getName()+"','"+grouptopic.getDescription()+")";
			stmt.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	public void updateGroupTopic(GroupTopic grouptopic) {
		try {
			Statement stmt=con.createStatement();
			String sql = "UPDATE GROUPTOPIC SET name = '"+grouptopic.getName()+"',description = '"+grouptopic.getDescription()+"' WHERE grouptopicid = "+grouptopic.getGrouptopicid()+"";
			stmt.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	public void deleteGroupTopic(int id) {
		try {
			Statement stmt=con.createStatement();
			String sql = "DELETE FROM GROUPTOPC WHERE grouptopicid = "+id+"";
			stmt.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}
