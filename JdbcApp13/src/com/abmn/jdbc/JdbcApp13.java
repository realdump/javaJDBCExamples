package com.abmn.jdbc;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcApp13 {

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
            data = data +"<html><body><table align='center' border='1'>";
            data = data +"<tr><th>ENO</th><th>ENAME</th><th>ESAL</th><th>EDDR</th></tr>";
			while(rs.next()) {
				data = data + "<tr>";
				data = data + "<td>"+rs.getInt("ENO")+"</td>";
				data = data + "<td>"+rs.getString("ENAME")+"</td>";
				data = data + "<td>"+rs.getFloat("ESAL")+"</td>";
				data = data + "<td>"+rs.getString("EADDR")+"</td>";
				data = data + "</tr>";
			}
			data = data + "<table></body></html>";
			fos = new FileOutputStream("/home/abdul/Documents/GitHub/javaJDBCExamples/JdbcApp13/emp.html");
			byte[] b = data.getBytes();
			fos.write(b);
			System.out.println("emp1 table data transfered completed");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				con.close();
				st.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

	}

}
