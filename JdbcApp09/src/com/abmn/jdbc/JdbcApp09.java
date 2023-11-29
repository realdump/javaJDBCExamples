package com.abmn.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcApp09 {

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
            boolean b = st.execute("select * from emp1");
            System.out.println(b);
            rs = st.getResultSet();
            System.out.println("ENO\tENAME\tESAL\tEADDR");
            while(rs.next()) {
            	System.out.print(rs.getInt("ENO")+"\t");
            	System.out.print(rs.getString("ENAME")+"\t");
            	System.out.print(rs.getInt("ESAL")+"\t");
            	System.out.print(rs.getString("EADDR")+"\n");
            }
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
				st.close();
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
