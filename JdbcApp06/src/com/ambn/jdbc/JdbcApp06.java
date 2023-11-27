package com.ambn.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcApp06 {

	public static void main(String[] args) {
		Scanner scanner = null;
		Connection con = null;
		Statement st = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
            String user="root";
            String pass="root_pass_1234";
            String url = "jdbc:mysql://127.0.0.1:3306/employee?autoReconnect=true&useSSL=false&&allowPublicKeyRetrieval=true";
            con = DriverManager.getConnection(url,user,pass);
            st = con.createStatement();
            scanner = new Scanner(System.in);
			System.out.println("Enter Employee Id:");
			int eno=scanner.nextInt();
			int rowCount=st.executeUpdate("delete from emp1 where eno="+eno);
			System.out.println("Emp Record Deleted"+rowCount);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				st.close();
				scanner.close();
				con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

}
