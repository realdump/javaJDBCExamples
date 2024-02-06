package com.abmn.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class StudentService {
	Connection con;
	Statement st;
	ResultSet rs;
	StudentTo sto;
	public StudentService() {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
        String user="root";
        String pass="root_pass_1234";
        String url = "jdbc:mysql://127.0.0.1:3306/stu?autoReconnect=true&useSSL=false&&allowPublicKeyRetrieval=true";
        con = DriverManager.getConnection(url,user,pass);
		st=con.createStatement();
		} catch (Exception e) {
		}
		}
		public StudentTo search(String sid){
		try {
		rs=st.executeQuery("select * from student where sid='"+sid+"'");
		boolean b=rs.next();
		if(b==true){
		sto=new StudentTo();
		sto.setSid(rs.getString(1));
		sto.setSname(rs.getString(2));
		sto.setSaddr(rs.getString(3));
		}else{
		sto=null;
		}
		} catch (Exception e) {
		e.printStackTrace();
		}
		return sto;
		}
}

