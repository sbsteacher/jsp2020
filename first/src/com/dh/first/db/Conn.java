package com.dh.first.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conn {
		
	public static Connection getCon() throws Exception {
		final String dbURL = "jdbc:mysql://127.0.0.1:4406/first?serverTimezone=UTC";
		final String dbID = "root";
		final String dbPassword = "root";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(dbURL, dbID, dbPassword);
		System.out.println("DB 연결!");
		return con;
	}
}
