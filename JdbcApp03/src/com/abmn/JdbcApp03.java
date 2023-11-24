package com.abmn;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JdbcApp03 {

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
			System.out.println("Table Name");
			String tname = br.readLine();
			String primary_key_cols="";
			String query= "";
			int primary_key_count=0;
			query = query+"create table "+tname+"(";
			while(true) {
				System.out.println("Column Name:");
				String col_name = br.readLine();
				System.out.println("Column Data Type and Size :");
				String col_Type_size = br.readLine();
				System.out.println("Is it Primary key Column[yes/no]:");
				String primary_Key_Option = br.readLine();
				if(primary_Key_Option.equalsIgnoreCase("yes")) {
					primary_key_count = primary_key_count+1;
					if(primary_key_count == 1) {
						primary_key_cols = primary_key_cols + col_name;
					}else {
						primary_key_cols = primary_key_cols + ","+col_name;
					}
					
				}
				query = query+ col_name +" "+ col_Type_size;
				System.out.println("Need More Columns? [Yes/No]");
				String option = br.readLine();
				if(option.equalsIgnoreCase("yes")) {
					query = query +",";
					continue;
				}else {
					query = query + "," + "primary key("+ primary_key_cols+ "))";
					break;
				}
			}
			System.out.println(query);
			st.execute(query);
			
			System.out.println("Table "+tname+"is created successfully");
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
