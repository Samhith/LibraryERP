package com.javatpoint.servlets;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javatpoint.dao.StudentDao;
@WebServlet("/DeleteStudent1")
public class DeleteStudent1 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sid=request.getParameter("mail");
		StudentDao.delete(sid);
		response.sendRedirect("DeleteStudent");
	}
}
