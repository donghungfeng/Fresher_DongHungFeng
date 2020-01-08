package vnptit.nckh.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	Connection con = ConnectOracle.getConnection();

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Statement stmt;
		try {
			stmt = con.createStatement();
			String sql = "select * from ADM_USER WHERE USER_NAME = '"+username+"'";
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()) {
				return new User(username, "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6",
						new ArrayList<>());
			}
			return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}

}