package com.abmn.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JdbcApp07 {

	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
            String user="root";
            String pass="root_pass_1234";
            String url = "jdbc:mysql://127.0.0.1:3306/employee?autoReconnect=true&useSSL=false&&allowPublicKeyRetrieval=true";
            con = DriverManager.getConnection(url,user,pass);
            st = con.createStatement();
            int rowCount1 = st.executeUpdate("create table emp10 (ENO int(3) primary key, ENAME varchar(10))");
            System.out.println(rowCount1);
            
            int rowCount2 = st.executeUpdate("drop table emp10");
            System.out.println(rowCount2);
           
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				st.close();
				con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}

	}

}
