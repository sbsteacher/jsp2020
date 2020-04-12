package com.dh.first.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dh.first.Util;

@WebServlet("/board/del")
public class BoardDelSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pw = request.getParameter("pw");
		String i_board = request.getParameter("i_board");
		int intBoard = Util.parseStringToInt(i_board);
		
		System.out.println("pw : " + pw);
		System.out.println("i_board : " + intBoard);
		
		BoardVO param = new BoardVO();
		param.setI_board(intBoard);
		param.setPw(pw);
		
		int result = BoardDAO.delBoard(param);//(리턴값) 0: 문제 발생, 1: 삭제 완료
		
		if(result == 0) {
			request.setAttribute("msg", "비밀번호를 확인해주세요");	
			RequestDispatcher rd = request.getRequestDispatcher("/board/detail?i_board=" + i_board);
			rd.forward(request, response);
			
		} else {
			response.sendRedirect("/board/list");
		}
		
	}

}
