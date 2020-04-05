package com.dh.first.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dh.first.test.TestVO;

public class TestDAO {
	public static TestVO getOne(int pk) {
		TestVO vo = new TestVO();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = " SELECT * FROM test WHERE pk = ? ";
		
		try {
			con = Conn.getCon();			
			ps = con.prepareStatement(sql);		
			ps.setInt(1, pk);			
			rs = ps.executeQuery();						
			while(rs.next()) {				
				String val = rs.getString("val");				
				vo.setPk(pk);
				vo.setVal(val);
			}		
		} catch (Exception e) {			
			e.printStackTrace();
		} finally {
			Conn.close(con, ps, rs);	
		}
		
		return vo;
	}
		
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
		} catch (Exception e) {			
			e.printStackTrace();
		} finally {
			Conn.close(con, ps, rs);	
		}
		
		return list;
	}
	public static void update(TestVO vo) {
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = " UPDATE test "
				+ " SET val = ? "
				+ " WHERE pk = ? ";
	
		try {
			con = Conn.getCon();			
			ps = con.prepareStatement(sql);
			ps.setString(1, vo.getVal());
			ps.setInt(2, vo.getPk());			
			ps.execute();
		} catch (Exception e) {			
			e.printStackTrace();
		} finally {
			Conn.close(con, ps, null);	
		}
	}
	
	public static void insert(TestVO vo) {		
		if(vo.getVal().indexOf(";") > 0) {
			return;
		}
		
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = " INSERT INTO test "
				+ " (pk, val)"
				+ " VALUES"
				+ " (?, ?) ";		
				
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
	
	//삭제
	public static void delete(int pk) {		
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = " DELETE FROM test WHERE pk = ? ";
		
		try {
			con = Conn.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, pk);
			
			ps.execute();
		} catch (Exception e) {			
			e.printStackTrace();
		} finally {
			Conn.close(con, ps, null);
		}
	}
	
}
















