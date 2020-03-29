package com.dh.first.exam;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/exam")
public class ExamSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
   		
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/exam/exam.jsp");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("exam - doPost");
		String nm = request.getParameter("nm");
		String age = request.getParameter("age");
				
		int intAge = Integer.parseInt(age);
		
		System.out.println("nm : " + nm);
		System.out.println("age : " + age);	
				
		RequestDispatcher rd = request.getRequestDispatcher("/exam2");
		request.setAttribute("rNm", nm);
		rd.forward(request, response);
		//response.sendRedirect("/exam2?nm=" + nm);
	}

}







