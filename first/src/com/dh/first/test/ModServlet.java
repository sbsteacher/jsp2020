package com.dh.first.test;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dh.first.db.TestDAO;

@WebServlet("/mod")
public class ModServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pk = request.getParameter("pk");
		int intPk = Integer.parseInt(pk);
		
		TestVO vo = TestDAO.getOne(intPk);
		request.setAttribute("vo", vo);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/test/mod.jsp");		
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
