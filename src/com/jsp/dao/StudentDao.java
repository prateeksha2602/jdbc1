package com.jsp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.jsp.dto.Student;
import com.jsp.service.Service;

public class StudentDao {
	
	Service service=new Service();
	
	//INSERT
	public Student saveStudent(Student student) {
	Connection connection=service.getConnection();
	String sql="INSERT INTO studentdetails VALUES(?,?,?)";
	
	try {
		PreparedStatement preparedStatement=connection.prepareStatement(sql);
		preparedStatement.setInt(1, student.getId());
		preparedStatement.setString(2, student.getName());
		preparedStatement.setString(3, student.getEmail());
		
		preparedStatement.execute();
		connection.close();
		System.out.println(student.getId()+"HAS BEEN SAVED");
		
		
	} catch (SQLException e) {
	
		e.printStackTrace();
	}
	return student;
	}
	
	//DELETE
	public Student deleteStudent(Student student) {
		Connection connection=service.getConnection();
		String sql="DELETE FROM studentdetails WHERE ID=?";
		
		
		try {
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, student.getId());
		preparedStatement.executeUpdate();
		connection.close();
		
		System.out.println("Closed");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return student;
	}
	
	
	//UPDATE
	public Student updateStudent(Student student) {
		Connection connection=service.getConnection();
		String sql="UPDATE studentdetails SET NAME=? WHERE ID=?";
		
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, student.getId());
			preparedStatement.executeUpdate();
			connection.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return student;
	}
}
