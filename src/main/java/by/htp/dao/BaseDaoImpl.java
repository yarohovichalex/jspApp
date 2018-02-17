package by.htp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import by.htp.bean.User;


public class BaseDaoImpl implements BaseDao{
	
	private static final String url = "jdbc:mysql://localhost/logindb?"
			+ "useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode"
			+ "=false&serverTimezone=UTC&useSSL=false";
	
	public User searchUser(String login, String password) {
		User us = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");			
		} catch (ClassNotFoundException e1) {			
			e1.printStackTrace();
		}
		
		try(Connection cn = DriverManager.getConnection(url,"root","root")){
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery("select * from user");
			
			while(rs.next()) {
//				books.add(new Book(rs.getInt("id"), rs.getString("brief"), new Author(rs.getString("author"), new Date(1994,06,13))));
				//System.out.println(rs.getString("login"));
				if (rs.getString("login").equals(login) && rs.getString("login").equals(password)) {
					us = new User();
					us.setLogin(rs.getString("login"));
					us.setPassword(rs.getString("password"));
					us.setRole(rs.getString("role"));
	                System.out.println("успешно нашел, роль:" + rs.getString("role") + " имя: " + rs.getString("login"));
	            }
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}	
		 
		
		return us;		
	}
	
}
