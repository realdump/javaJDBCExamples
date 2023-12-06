package com.abmn.factory;

import com.abmn.service.StudentService;
import com.abmn.service.StudentServiceImpl;

public class StudentServiceFactory {
	private static StudentService studentService = null;
	static {
		studentService = new StudentServiceImpl();
	}
	public static StudentService getStudentService() {
		return studentService;
	}
	
}
