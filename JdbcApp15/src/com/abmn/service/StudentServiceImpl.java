package com.abmn.service;

import com.abmn.dao.StudentDao;
import com.abmn.dto.Student;
import com.abmn.factory.StudentDaoFactory;

public class StudentServiceImpl implements StudentService {

	@Override
	public String addStudent(Student student) {
		StudentDao studentDao = StudentDaoFactory.getStudentDao();
		String status = studentDao.add(student);
		return status;
	}

	@Override
	public Student searchStudent(String sid) {
		
		return null;
	}

	@Override
	public String updateStudent(Student student) {
		
		return null;
	}

	@Override
	public String deleteStudent(String sid) {
		
		return null;
	}

}
