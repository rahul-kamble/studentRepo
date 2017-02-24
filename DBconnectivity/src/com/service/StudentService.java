package com.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.modelclass.StudentModel;

public interface StudentService {

	public void saveStudent(StudentModel s);

	public void updateStudent(StudentModel s);

	public ResultSet getFirstStudent();

	public ResultSet getLastStudent();

	public StudentModel getPreviousRecord(int id) throws SQLException;
	
	public void deleteStudent(int id);

	public ResultSet searchStudent(String rollNumber);
	
	public StudentModel getNextRecord(int id) throws SQLException;
}
