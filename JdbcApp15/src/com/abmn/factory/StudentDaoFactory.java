package com.abmn.factory;

import com.abmn.dao.StudentDao;
import com.abmn.dao.StudentDaoImpl;

public class StudentDaoFactory {
	private static StudentDao studentDao = null;
	static {
		studentDao = new StudentDaoImpl();
	}
public static StudentDao getStudentDao() {
	return studentDao;
}
}
