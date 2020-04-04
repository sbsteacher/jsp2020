package com.dh.first.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
	
	public static void close(Connection con, PreparedStatement ps, ResultSet rs) {
		if(rs != null) {
			try { rs.close(); } catch(Exception e) { e.printStackTrace(); }
		}
		
		if(ps != null) {
			try { ps.close(); } catch(Exception e) { e.printStackTrace(); }
		}
		
		if(con != null) {
			try { con.close(); } catch(Exception e) { e.printStackTrace(); }
		}
	}
}








