package com.dh.first.db;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.dh.first.test.TestVO;

public class TestDAO {
	public static void insert(TestVO vo) {
		Connection con = null;
		PreparedStatement ps = null;
		
		if(val.indexOf(";") > 0) {
			return;
		}
		/*
		String sql = " INSERT INTO test "
				+ " (pk, val)"
				+ " VALUES"
				+ " ( " + pk + ", '" + val +"') ";		
		
		
		String sql = String.format(" INSERT INTO test "
				+ " (pk, val)"
				+ " VALUES"
				+ " ( %d, '%s') ", pk, val);
		*/
		String sql = " INSERT INTO test "
				+ " (pk, val)"
				+ " VALUES"
				+ " (?, ?) ";		
		
		System.out.println("sql : " + sql);
		try {
			con = Conn.getCon();			
			ps = con.prepareStatement(sql);
			ps.setInt(1, pk);
			ps.setString(2, val);
			
			ps.execute();			
		} catch (Exception e) {			
			e.printStackTrace();
		} finally {
			Conn.close(con, ps, null);	
		}
		
		
	}
}
