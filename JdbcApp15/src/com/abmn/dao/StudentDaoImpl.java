package com.abmn.dao;

import java.sql.Connection;
import java.sql.Statement;

import com.abmn.dto.Student;
import com.abmn.factory.ConnectionFactory;

public class StudentDaoImpl implements StudentDao {

	@Override
	public String add(Student student) {
		try {
			Connection con = ConnectionFactory.getConnection();
			Statement st = con.createStatement();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Student search(String sid) {
		
		return null;
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
