package com.dh.first.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dh.first.db.Conn;
import com.dh.first.test.TestVO;

public class BoardDAO {
	
	public static int boardInsert(BoardVO vo) {
		int result = 0;
		
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = " INSERT INTO board "
				+ " (title, content, pw) "
				+ " VALUES "
				+ " (?, ?, ?) ";
		
		try {
			con = Conn.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, vo.getTitle());
			ps.setString(2,  vo.getContent());
			ps.setString(3, vo.getPw());
			
			result = ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Conn.close(con, ps, null);
		}
		
		return result;
	}
	

	public static BoardVO getBoardOne(BoardVO param) {
		BoardVO vo = null;
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = " SELECT title, content, r_dt, m_dt "
				+ " FROM board"
				+ " WHERE i_board = ? ";
		
		if(param.getPw() != null) {
			sql += " and pw = ? ";
		}
		
		try {
			con = Conn.getCon();			
			ps = con.prepareStatement(sql);	
			ps.setInt(1, param.getI_board());
			if(param.getPw() != null) {
				ps.setString(2, param.getPw());
			}
			rs = ps.executeQuery();
						
			while(rs.next()) {	
				vo = new BoardVO();
				String title = rs.getString("title");
				String content = rs.getString("content");
				String r_dt = rs.getString("r_dt");
				String m_dt = rs.getString("m_dt");
								
				vo.setI_board(param.getI_board()); //디테일 화면에서 삭제 or 수정 때 사용하기 위해
				vo.setTitle(title);
				vo.setContent(content);
				vo.setR_dt(r_dt);
				vo.setM_dt(m_dt);
			}		
		} catch (Exception e) {			
			e.printStackTrace();
		} finally {
			Conn.close(con, ps, rs);	
		}
		
		return vo;
	}
	
	public static List<BoardVO> getBoardList() {
		List<BoardVO> list = new ArrayList();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = " SELECT i_board, title, r_dt"
				+ " FROM board"
				+ " ORDER BY i_board DESC ";
		
		try {
			con = Conn.getCon();			
			ps = con.prepareStatement(sql);			
			rs = ps.executeQuery();
						
			while(rs.next()) {
				int i_board = rs.getInt("i_board");
				String title = rs.getString("title");
				String r_dt = rs.getString("r_dt");
				
				BoardVO vo = new BoardVO();
				vo.setI_board(i_board);
				vo.setTitle(title);
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
	
	public static void updBoard(BoardVO param) {
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = " UPDATE board "
				+ " SET title = ? "
				+ " , content = ? "
				+ " , pw = ? "
				+ " , m_dt = now() "
				+ " WHERE i_board = ? ";		
		try {
			con = Conn.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, param.getTitle());
			ps.setString(2, param.getContent());
			ps.setString(3,  param.getPw());
			ps.setInt(4, param.getI_board());
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Conn.close(con, ps, null);	
		}
	}	
	
	public static int delBoard(BoardVO param) {
		int result = 0;
		
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = " DELETE FROM board WHERE i_board = ? and pw = ? ";
		
		try {
			con = Conn.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, param.getI_board());
			ps.setString(2, param.getPw());
						
			result = ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Conn.close(con, ps, null);	
		}
		return result;
	}
}











