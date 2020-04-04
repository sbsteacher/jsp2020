package com.dh.first.exam;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dh.first.db.Conn;

@WebServlet("/exam2")
public class ExamSer2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * try {  
		 * 		Conn.getCon();
		 * 
		 * 
		 * } catch (Exception e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */
		String nm = request.getParameter("nm");
		System.out.println("exam2 nm : " + nm);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/exam/exam2.jsp");
		request.setAttribute("fileName", "exam2jsp");
		request.setAttribute("abc", nm);
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nm = (String)request.getAttribute("rNm");
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/exam/exam2.jsp");
		request.setAttribute("fileName", "exam2jsp");
		request.setAttribute("abc", nm);
		rd.forward(request, response);
		
		response.sendRedirect("");
	}

}








