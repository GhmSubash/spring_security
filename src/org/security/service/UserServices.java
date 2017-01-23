package org.security.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.security.auth.model.User;


public class UserServices {
	
	public User loadUserByUserName(String username){
		
		Connection connection = this.getConnection();
		try {
			String query = "select * from app_user where User_Name = "+"'"+username+"'";
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet rs = statement.executeQuery();
			while(rs.next()){
				User user = new User();
				user.setId(rs.getInt(1));
				user.setUsername(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setEnabled(rs.getBoolean(4));
				user.setAuthority(rs.getString(5));
				
				System.out.println("\nUser ID : "+user.getId());
				System.out.println("\nUsername : "+user.getUsername());
				System.out.println("\nPassword : "+user.getPassword());
				System.out.println("\nEnabled : "+user.isEnabled());
				System.out.println("\nIs account Expired : "+user.isAccountNonExpired());
				System.out.println("\nIs account locked : "+user.isAccountNonLocked());
				System.out.println("\nIs credentials Expired : "+user.isCredentialsNonExpired());
				
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Connection getConnection(){
		
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/spr_security","root","");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException ex){
			
		}
		
		return connection;
	}

}
