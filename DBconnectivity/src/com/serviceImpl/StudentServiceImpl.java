package com.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.comman.DbHelper;
import com.modelclass.StudentModel;
import com.service.StudentService;

public class StudentServiceImpl implements StudentService {

	ResultSet res;
	private int rollNumber;

	@Override
	public void saveStudent(StudentModel s) {
		try {
			Connection con = DbHelper.getConnection();
			String q = "insert into student(rollno,name,address,marks,age,gender) value(?,?,?,?,?,?)";
			PreparedStatement stmt = con.prepareStatement(q);
			stmt.setInt(1, s.getRollNo());
			stmt.setString(2, s.getName());
			stmt.setString(3, s.getAddress());
			stmt.setInt(4, s.getMarks());
			stmt.setString(5, s.getAge());
			stmt.setInt(6, s.getGender());
			stmt.execute();

		} catch (SQLException e) {
			System.out.println("Student Data Not Save !!");
			e.printStackTrace();
		}
	}

	@Override
	public void updateStudent(StudentModel s) {

		try {
			Connection con = DbHelper.getConnection();

			String checkQuery = "select rollno from student where rollno =" + s.getRollNo();
			Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery(checkQuery);

			while (res.next()) {
				rollNumber = res.getInt(1);
			}
			if (rollNumber == s.getRollNo()) {
				String q = "Update student set rollno =" + s.getRollNo() + ", name ='" + s.getName() + "', address= '"
						+ s.getAddress() + "' ,marks=" + s.getMarks() + ", age=" + s.getAge() + ", gender="
						+ s.getGender() + " where rollno =" + s.getRollNo();
				System.out.println(q);
				PreparedStatement preparedStatment = con.prepareStatement(q);
				int count = preparedStatment.executeUpdate(q);
				System.out.println("Updated queries: " + count);
			} else {
				System.out.println("either roll number already exist or not present !!");
			}

		} catch (SQLException e) {
			System.out.println("Student Data Not Save !!");
			e.printStackTrace();
		}
	}

	@Override
	public ResultSet getFirstStudent() {
		res = null;
		try {
			Connection con = DbHelper.getConnection();
			String checkQuery = "select rollno,name,address,marks,age,gender from student ORDER BY id ASC LIMIT 1";
			Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery(checkQuery);
			return res;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;

	}

	@Override
	public ResultSet getLastStudent() {
		res = null;
		try {
			Connection con = DbHelper.getConnection();
			String checkQuery = "select rollno,name,address,marks,age,gender from student ORDER BY id DESC LIMIT 1";

			Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery(checkQuery);
			return res;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public StudentModel getPreviousRecord(int studentId) throws SQLException {
		String query = "SELECT * FROM student WHERE id < ? ORDER BY id DESC LIMIT 1";

		Connection connection = DbHelper.getConnection();
		PreparedStatement statement = (PreparedStatement) connection.prepareStatement(query);
		statement.setInt(1, studentId);
		ResultSet resultSet = statement.executeQuery();

		StudentModel studentModel = null;
		while (resultSet.next()) {
			studentModel = new StudentModel();
			studentModel.setName(resultSet.getString("name"));
			studentModel.setAddress(resultSet.getString("address"));
			studentModel.setAge(resultSet.getString("age"));
			studentModel.setRollNo(resultSet.getInt("rollNo"));
			studentModel.setMarks(resultSet.getInt("marks"));
			studentModel.setGender(resultSet.getInt("gender"));
		}
		return studentModel;
	}

	@Override
	public StudentModel getNextRecord(int id) throws SQLException {
		String query = "SELECT * FROM student WHERE id > ? ORDER BY id LIMIT 1";
		Connection connection = DbHelper.getConnection();
		PreparedStatement statement = (PreparedStatement) connection.prepareStatement(query);
		statement.setInt(1, id);
		ResultSet resultSet = statement.executeQuery();

		StudentModel studentModel = null;
		while (resultSet.next()) {
			studentModel = new StudentModel();
			studentModel.setName(resultSet.getString("name"));
			studentModel.setAddress(resultSet.getString("address"));
			studentModel.setAge(resultSet.getString("age"));
			studentModel.setRollNo(resultSet.getInt("rollNo"));
			studentModel.setMarks(resultSet.getInt("marks"));
			studentModel.setGender(resultSet.getInt("gender"));
		}
		return studentModel;
	}

	@Override
	public void deleteStudent(int id) {
		try {
			Connection con = DbHelper.getConnection();
			String checkQuery = "DELETE FROM student where rollno =" + id;

			Statement stmt = con.createStatement();
			stmt.executeUpdate(checkQuery);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ResultSet searchStudent(String rollNumber) {
		res = null;
		try {
			Connection con = DbHelper.getConnection();
			String searchData = "select rollno,name,address,marks,age,gender from student where rollno =" + rollNumber;
			Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery(searchData);
			return res;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	public int getIdFromRollNumber(int rollNumber) {
		res = null;
		int id = 0;
		try {
			Connection con = DbHelper.getConnection();
			String checkQuery = "SELECT id FROM student WHERE rollno = " + rollNumber;

			Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery(checkQuery);
			while (res.next()) {
				id = res.getInt("id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}

}
