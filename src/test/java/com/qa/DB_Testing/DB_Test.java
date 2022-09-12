package com.qa.DB_Testing;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

public class DB_Test extends Base {
@Test
	public void getTableData() throws SQLException {
		con=this.setup();
		Statement stmt = con.createStatement();
		ResultSet rs =stmt.executeQuery("select* from emp_table");
		while(rs.next()) {
				int id = rs.getInt(1);
				String name=rs.getString(2);
				int age = rs.getInt(3);
				int salary = rs.getInt(4);
				int phone_no = rs.getInt(5);
				String emailid = rs.getString(6);
						System.out.println(id+" "+name+" "+age+" "+salary+" "+phone_no+" "+emailid);
						}
	}
@Test
public void insertData() throws SQLException {
	con=this.setup();
	PreparedStatement stmt = con.prepareStatement("insert into emp_table(id,name,age,salary,phone_no,emailid)values(?,?,?,?,?,?)");
	stmt.setInt(1, 4);
	stmt.setString(2,"sandy");
	stmt.setInt(3, 23);
	stmt.setInt(4, 23000);
	stmt.setInt(5,887654444);
	stmt.setString(6,"sandy@gmail.com");
	stmt.executeUpdate();
	getTableData();

}

@Test
public void deleteData() throws SQLException {
	con =this.setup();
	PreparedStatement pre = con.prepareStatement("delete from emp_table where name = ? ");
	pre.setString(1, "sandeep");
	pre.executeUpdate();
	getTableData();
}

@Test
public void updateData() throws SQLException {
	con = this.setup();
	PreparedStatement pre = con.prepareStatement("update emp_table set name=? where id=?");
	pre.setString(1, "sandy");       
	pre.setInt(2, 3);  

	pre.executeUpdate();
	getTableData();
}

}
