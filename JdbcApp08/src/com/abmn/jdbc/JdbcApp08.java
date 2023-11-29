package com.abmn.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcApp08 {

	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
            String user="root";
            String pass="root_pass_1234";
            String url = "jdbc:mysql://127.0.0.1:3306/employee?autoReconnect=true&useSSL=false&&allowPublicKeyRetrieval=true";
            con = DriverManager.getConnection(url,user,pass);
            st = con.createStatement();
            rs = st.executeQuery("select * from emp1");
            System.out.println("ENO\tENAME\tESAL\tEDDR");
            System.out.println("-----------------------------");
            while(rs.next()) {
            	System.out.print(rs.getInt(1)+"\t");
            	System.out.print(rs.getString(2)+"\t");
            	System.out.print(rs.getFloat(3)+"\t");
            	System.out.print(rs.getString(4)+"\n");
            }
		} catch (Exception e) {
			
		} finally {
			try {
				con.close();
				st.close();
				rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}

	}

}
