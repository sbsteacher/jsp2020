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
				
		request.setAttribute("vo", TestDAO.getOne(intPk));
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/test/mod.jsp");		
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String pk = request.getParameter("pk");
		int intPk = Integer.parseInt(pk);
		String val = request.getParameter("val");
		TestVO vo = new TestVO();
		vo.setPk(intPk);
		vo.setVal(val);
		TestDAO.update(vo);
		
		response.sendRedirect("/list");
	}

}







