package com.dh.first.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board/list")
public class BoardListSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
        
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String regmodresult = request.getParameter("regmodresult");
		if(regmodresult != null && regmodresult.equals("0")) {
			request.setAttribute("msg", "에러가 발생되었습니다.");
		}
		
		List<BoardVO> list = BoardDAO.getBoardList();
		
		for(BoardVO vo : list) {
			System.out.println(vo.getTitle());
		}
		
		request.setAttribute("list", BoardDAO.getBoardList());
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/board/boardList.jsp");			
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
