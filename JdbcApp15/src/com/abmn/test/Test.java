package com.abmn.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.abmn.dto.Student;
import com.abmn.factory.ConnectionFactory;
import com.abmn.factory.StudentServiceFactory;
import com.abmn.service.StudentService;

public class Test {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			System.out.println("1. Add Student");
			System.out.println("2. Search Student");
			System.out.println("3. Update Student");
			System.out.println("4. Delete Student");
			System.out.println("5. Exit");
			System.out.println("Enter Your Option:");
			int option = Integer.parseInt(br.readLine());
			String sid = "";
			String sname = "";
			String saddr = "";
			Student student = null;
			StudentService StudentService = null;
			String status = "";
			switch (option) {
			case 1: 
				System.out.println("++++ADD Student+++++");
				System.out.println("Student Id:");
				sid = br.readLine();
				System.out.println("Student Name:");
				sname = br.readLine();
				System.out.println("Student Address:");
				saddr = br.readLine();
				student = new Student();
				student.setSid(sid);
				student.setSname(sname);
				student.setSaddr(saddr);
				
				StudentService = StudentServiceFactory.getStudentService();
				status = StudentService.addStudent(student);
				System.out.println(status);
				
				break;
			case 2: 
				break;
			case 3: 
				break;
			case 4: 
				break;
			case 5: 
				System.out.println("Thanks for using the APP");
				ConnectionFactory.cleanUp();
				System.exit(0);
				break;
			
			default:
				System.out.println("Please Enter the Option 1-5 only");
				break;
			}
		}
	}

}
