package com.abmn.jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.StackWalker.Option;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JdbcApp04 {

	public static void main(String[] args) {
		BufferedReader br = null;
		Connection con = null;
		Statement st = null;
		try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
	            String user="root";
	            String pass="root_pass_1234";
	            String url = "jdbc:mysql://127.0.0.1:3306/employee?autoReconnect=true&useSSL=false&&allowPublicKeyRetrieval=true";
	            con = DriverManager.getConnection(url,user,pass);
	            st = con.createStatement();
	            br = new BufferedReader(new InputStreamReader(System.in));
	            while(true) {
	            	System.out.println("Employee Number :");
	            	int eno = Integer.parseInt(br.readLine());
	            	System.out.println("Employee Name:");
	            	String ename = br.readLine();
	            	System.out.println("Employee Salary:");
	            	float esal = Float.parseFloat(br.readLine());
	            	System.out.println("Employee Address:");
	            	String eaddr = br.readLine();
	            	st.executeUpdate("insert into emp1 values("+eno+",'"+ename+"',"+esal+",'"+eaddr+"')");
	            	System.out.println("Employee "+eno+" Inserted Successfully");
	            	System.out.println("Need to Insert Employee?[Yes/No]:");
	            	String option =br.readLine();
	            	if(option.equalsIgnoreCase("yes")) {
	            		continue;
	            	}else {
	            		break;
	            	}
	            }
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				br.close();
				st.close();
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
