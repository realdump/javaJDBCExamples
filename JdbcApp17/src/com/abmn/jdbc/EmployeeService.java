package com.abmn.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class EmployeeService {
	Connection con;
	Statement st;
	ResultSet rs;
	String status="";
	public EmployeeService() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
            String user="root";
            String pass="root_pass_1234";
            String url = "jdbc:mysql://127.0.0.1:3306/employee?autoReconnect=true&useSSL=false&&allowPublicKeyRetrieval=true";
            con = DriverManager.getConnection(url,user,pass);
            st = con.createStatement();
		st=con.createStatement();
		} catch (Exception e) {
		e.printStackTrace();
		}
		}
		public String add(int eno,String ename, float esal, String eaddr){
		try {
		rs=st.executeQuery("select * from emp1 where eno="+eno);
		boolean b=rs.next();
		if(b==true){
			
			status="Employee Existed Already";
		}else{
		st.executeUpdate("insert into emp1 values("+eno+",'"+ename+"',"+esal+",'"+eaddr+"')");
		status="Employee Registration Success";
		}
		} catch (Exception e) {
		status="Employee Registration Failure";
		e.printStackTrace();
		}
		return status;
		}
		}
	


