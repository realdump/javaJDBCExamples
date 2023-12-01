package com.abmn.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcApp11 {

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
            rs = st.executeQuery("update emp1 set ESAL=ESAL-500 where ENO=222");
            int rowCount = st.getUpdateCount();
            System.out.println("RowCount:"+rowCount);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				st.close();
				con.close();
				rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

}
