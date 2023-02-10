package com.jsp.controller;

import com.jsp.dao.StudentDao;
import com.jsp.dto.Student;

public class Controller {
	public static void main(String[] args) {
		Student student=new Student();
		student.setId(1);
		student.setName("Scott");
		student.setEmail("scott@mail.com");
		
		StudentDao studentDao=new StudentDao();
		studentDao.saveStudent(student);
		
	}
}
