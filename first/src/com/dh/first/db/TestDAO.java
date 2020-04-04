package com.dh.first.db;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class TestDAO {
	public static void insert(int pk, String val) {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = " INSERT INTO test "
				+ " (pk, val)"
				+ " VALUES"
				+ " ( " + pk + ", '" + val +"') ";		
		/*
		sql = String.format(" INSERT INTO test "
				+ " (pk, val)"
				+ " VALUES"
				+ " ( %d, '%s') ", pk, val);
		*/
		
		System.out.println("sql : " + sql);
		try {
			con = Conn.getCon();			
			ps = con.prepareStatement(sql);
			ps.execute();			
		} catch (Exception e) {			
			e.printStackTrace();
		} finally {
			Conn.close(con, ps, null);	
		}
		
		
	}
}
