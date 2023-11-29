package com.abmn.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcApp10 {

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
            boolean b = st.execute("update emp1 set ESAL=ESAL+100 where ENO=222");
            System.out.println(b);
            int rowCount = st.getUpdateCount();
            System.out.println("Records Update:"+rowCount);
           
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
				st.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
