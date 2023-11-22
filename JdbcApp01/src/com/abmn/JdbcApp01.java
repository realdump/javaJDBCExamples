package com.abmn;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcApp01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con = null;
		Statement st= null;
		try {
			 Class.forName("com.mysql.jdbc.Driver");
	            String user="root";
	            String pass="root_pass_1234";
	            String url = "jdbc:mysql://127.0.0.1:3306/employee?autoReconnect=true&useSSL=false&&allowPublicKeyRetrieval=true";
	            con = DriverManager.getConnection(url,user,pass);
			st = con.createStatement();
			String query = "create table emp1(ENO int primary key, ENAME varchar(10), ESAL float(5), EADDR varchar(10))";
			st.executeUpdate(query);
			System.out.println("Table emp1 created successfully");
			
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
