package com.dh.first.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dh.first.Util;

@WebServlet("/board/detail")
public class BoardDetailSer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String i_board = request.getParameter("i_board");
		int intBoard = Util.parseStringToInt(i_board);
		
		System.out.println("i_board : " + intBoard);
		
		if(intBoard != 0) {
			BoardVO param = new BoardVO();
			param.setI_board(intBoard);
			
			BoardVO vo = BoardDAO.getBoardOne(param);
			
			if(vo != null) {
				System.out.println("title : " + vo.getTitle());
				System.out.println("content : " + vo.getContent());
				System.out.println("r_dt : " + vo.getR_dt());
				System.out.println("m_dt : " + vo.getM_dt());
				
				request.setAttribute("data", vo);	
			}
		}
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/board/boardDetail.jsp");			
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
