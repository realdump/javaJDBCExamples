package com.abmn.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.cj.jdbc.Driver;

public class JdbcApp05 {

	public static void main(String[] args) {
		Scanner scanner = null;
		Connection con = null;
		Statement st =null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
            String user="root";
            String pass="root_pass_1234";
            String url = "jdbc:mysql://127.0.0.1:3306/employee?autoReconnect=true&useSSL=false&&allowPublicKeyRetrieval=true";
            con = DriverManager.getConnection(url,user,pass);
            st = con.createStatement();
            scanner = new Scanner(System.in);
            /*System.out.println("Salary Range:");*/
            System.out.println("Enter Employee No.:");
            /*float sal_Range = scanner.nextFloat();*/
            int eno = scanner.nextInt();
            System.out.println("Bonus Amount: ");
            int bonus_Amt = scanner.nextInt();
            /*int rowCount = st.executeUpdate("update emp1 set esal=esal+" + bonus_Amt);*/
            System.out.println("update emp1 set esal=esal+" +bonus_Amt +" where eno="+eno);
			int rowCount = st.executeUpdate("update emp1 set esal=esal+" +bonus_Amt + " where eno="+eno);
            System.out.println("Records Updated:" +rowCount);
            
            
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
