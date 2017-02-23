package com.comman;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbHelper {

	public static Connection getConnection() throws SQLException{

		Connection con = DriverManager.getConnection("jdbc:mysql://192.168.99.101:3306/studentDb?verifyServerCertificate=false&useSSL=true", "root", "root");
		return con;
	}
}
