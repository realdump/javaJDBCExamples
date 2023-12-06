package com.abmn.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.abmn.dto.Student;
import com.abmn.factory.ConnectionFactory;

public class StudentDaoImpl implements StudentDao {

	@Override
	public String add(Student student) {
		String status = "";
		try {
			Connection con = ConnectionFactory.getConnection();
			Statement st = con.createStatement();
			Student std = search(student.getSid());
			if (std ==null) {
				int rowCount = st.executeUpdate("insert into student values('"+student.getSid()+"','"+student.getSname()+"','"+student.getSaddr()+"')");
				if(rowCount == 1) {
					status = "Student Inserted Successfully";	
				} else {
					status = "Student Insertion Failed";
				}
			}else {
				status = "Student Already Exist";
			}
		} catch (Exception e) {
			status = "Student Insert failed";
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public Student search(String sid) {
		Student student = null;
		try {
			Connection con = ConnectionFactory.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from student where SID = '"+sid+"'");
			boolean b = rs.next();
			if (b == true) {
				student = new Student();
				student.setSid(rs.getString("SID"));
				student.setSaddr(rs.getString("SNAME"));
				student.setSaddr(rs.getString("SADDR"));
			}else {
				student = null;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return student;
	}

	@Override
	public String update(Student student) {
		
		return null;
	}

	@Override
	public String delete(String sid) {
		
		return null;
	}

}
