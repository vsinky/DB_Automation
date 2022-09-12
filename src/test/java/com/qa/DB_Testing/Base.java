package com.qa.DB_Testing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Base {
	public static Connection con;
	
	@BeforeTest
	public Connection setup() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/mysql_db";
		String userName ="root";
		String pwd ="123456";
		con= DriverManager.getConnection(url,userName,pwd);
		//Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","123456");
		return con;	
	}
	
	@AfterTest
	public void tearDown() throws SQLException {
		con.close();
	}
}
