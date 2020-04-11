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
		}
		
		return result;
	}
	

	public static List<BoardVO> getBoardList() {
		List<BoardVO> list = new ArrayList();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = " SELECT i_board, title, m_dt FROM board ";
		
		try {
			con = Conn.getCon();			
			ps = con.prepareStatement(sql);			
			rs = ps.executeQuery();
						
			while(rs.next()) {
				int i_board = rs.getInt("i_board");
				String title = rs.getString("title");
				String m_dt = rs.getString("title");
				
				BoardVO vo = new BoardVO();
				vo.setI_board(i_board);
				vo.setTitle(title);
				vo.setM_dt(m_dt);
				
				list.add(vo);
			}		
		} catch (Exception e) {			
			e.printStackTrace();
		} finally {
			Conn.close(con, ps, rs);	
		}
		
		return list;
	}
}











