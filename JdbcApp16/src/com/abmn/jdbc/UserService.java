package com.abmn.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserService {
	Connection con;
	Statement st;
	ResultSet rs;
	String status="";
	public UserService() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
            String user="root";
            String pass="root_pass_1234";
            String url = "jdbc:mysql://127.0.0.1:3306/employee?autoReconnect=true&useSSL=false&&allowPublicKeyRetrieval=true";
            con = DriverManager.getConnection(url,user,pass);
            st = con.createStatement();
            
		} catch (Exception e) {
		System.out.println(e);
		}
	}
	public String checkLogin(String uname,String upwd) {
		try {
			rs=st.executeQuery("select * from registered_Users where uname='"+uname+"' and upwd='"+upwd+"'");
					boolean b=rs.next();
					if(b==true){
					status="Login Success";
					}else{
					status="Login Failure";
					}
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}
}
