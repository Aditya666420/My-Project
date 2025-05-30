package com.voting.test.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class CP {
	static Connection con;
	public static Connection createCon()  {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String user="root";
			String password= "adityanath1234@#$";
			String url = "jdbc:mysql://localhost:3306/voting";
			con = DriverManager.getConnection(url,user,password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
		
	}
}
