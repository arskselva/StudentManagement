package com.app.training;

import java.sql.*;

public class ConnectionProvider {
	
	static Connection con;
	
	public static Connection CreateConnection() {
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			String user = "root";
			
			String password = "root";
			
			String url = "jdbc:mysql://localhost:3306/student_management";
			
			con = (Connection) DriverManager.getConnection(url, user, password);
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return con;
	}

}
