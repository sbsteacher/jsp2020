package com.dh.first.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dh.first.Util;

@WebServlet("/board/regmod")
public class BoardRegModSer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String i_board = request.getParameter("i_board");
		
		if(i_board != null) { //수정!!!			
			int intBoard = Util.parseStringToInt(i_board);
			String pw = request.getParameter("pw");
			
			BoardVO param = new BoardVO();
			param.setI_board(intBoard);
			param.setPw(pw);
			
			BoardVO vo = BoardDAO.getBoardOne(param);
			
			if(vo != null) {
				System.out.println("title : " + vo.getTitle());
				System.out.println("content : " + vo.getContent());
				System.out.println("r_dt : " + vo.getR_dt());
				System.out.println("m_dt : " + vo.getM_dt());
				
				request.setAttribute("data", vo);	
			} else { //비밀번호 틀렸음
				request.setAttribute("msg", "비밀번호를 확인해주세요");
				RequestDispatcher rd = request.getRequestDispatcher("/board/detail?i_board=" + i_board);
				rd.forward(request, response);
				return;
			}
		}
		
		RequestDispatcher rd = 
				request.getRequestDispatcher("/WEB-INF/jsp/board/boardRegMod.jsp");
		rd.forward(request, response);		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String i_board = request.getParameter("i_board");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String pw = request.getParameter("pw");
		
		System.out.println("i_board: " + i_board.equals(""));
		System.out.println("title: " + title);
		System.out.println("content: " + content);
		System.out.println("pw: " + pw);
		
		BoardVO vo = new BoardVO();
		vo.setTitle(title);
		vo.setContent(content);
		vo.setPw(pw);
		
		if(i_board.equals("")) { //등록
			int result = BoardDAO.boardInsert(vo);
			response.sendRedirect("/board/list?regmodresult=" + result);	
		
		} else { //수정
			int intBoard = Util.parseStringToInt(i_board);			
			vo.setI_board(intBoard);			
			BoardDAO.updBoard(vo); //무조건 수정!!!			
			response.sendRedirect("/board/detail?i_board=" + i_board);			
		}
	}
}





