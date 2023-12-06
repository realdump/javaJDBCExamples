package com.abmn.jdbc;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcApp14 {

	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		FileOutputStream fos = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
            String user="root";
            String pass="root_pass_1234";
            String url = "jdbc:mysql://127.0.0.1:3306/employee?autoReconnect=true&useSSL=false&&allowPublicKeyRetrieval=true";
            con = DriverManager.getConnection(url,user,pass);
            st = con.createStatement();
            rs = st.executeQuery("select * from emp1");
            String data = "";
            data = data  +"ENO,ENAME,ESAL,EADDR\n";
            while(rs.next()) {
				
				data = data +rs.getInt("ENO")+",";
				data = data +rs.getString("ENAME")+",";
				data = data +rs.getFloat("ESAL")+",";
				data = data +rs.getString("EADDR")+"\n";
			}
            fos = new FileOutputStream("/home/abdul/Documents/GitHub/javaJDBCExamples/JdbcApp14/emp.txt");
            byte[] b = data.getBytes();
            fos.write(b);
            System.out.println("Data Transfered");
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				fos.close();
				rs.close();
				st.close();
				con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

}
