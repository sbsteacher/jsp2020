package com.dh.first.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dh.first.test.TestVO;

public class TestDAO {
	public static List<TestVO> getList() {
		List<TestVO> list = new ArrayList();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = " SELECT * FROM test ";
		
		try {
			con = Conn.getCon();			
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int pk = rs.getInt("pk");
				String val = rs.getString("val");
				String r_dt = rs.getString("r_dt");
				
				TestVO vo = new TestVO();
				vo.setPk(pk);
				vo.setVal(val);
				vo.setR_dt(r_dt);
				
				list.add(vo);
			}			
			
			ps.execute();			
		} catch (Exception e) {			
			e.printStackTrace();
		} finally {
			Conn.close(con, ps, rs);	
		}
		
		return list;
	}
	
	public static void insert(TestVO vo) {
		Connection con = null;
		PreparedStatement ps = null;
		
		if(vo.getVal().indexOf(";") > 0) {
			return;
		}
		
		String sql = " INSERT INTO test "
				+ " (pk, val)"
				+ " VALUES"
				+ " (?, ?) ";		
		
		System.out.println("sql : " + sql);
		try {
			con = Conn.getCon();			
			ps = con.prepareStatement(sql);
			ps.setInt(1, vo.getPk());
			ps.setString(2, vo.getVal());
			
			ps.execute();			
		} catch (Exception e) {			
			e.printStackTrace();
		} finally {
			Conn.close(con, ps, null);	
		}
	}
	
	
}
