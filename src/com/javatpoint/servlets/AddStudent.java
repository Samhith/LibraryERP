package com.javatpoint.servlets;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javatpoint.beans.StudentBean;
import com.javatpoint.dao.StudentDao;
@WebServlet("/AddStudent")
public class AddStudent extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.println("<head>");
		out.println("<title>Add Student</title>");
		out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
		out.println("</head>");
		out.println("<body>");
		
		request.getRequestDispatcher("navlibrarian.html").include(request, response);
		out.println("<div class='container'>");
		
		String name=request.getParameter("name");
		String email=request.getParameter("mail");
		String smobile=request.getParameter("mobile");
		String uname=request.getParameter("uname");
		String password=request.getParameter("password");
		
		long mobile=Long.parseLong(smobile);
		StudentBean bean=new StudentBean(name, email, mobile, uname,password);
		StudentDao.save(bean);
		out.print("<h4>Student added successfully</h4>");
		request.getRequestDispatcher("addstudentform.html").include(request, response);
		
		
		out.println("</div>");
		request.getRequestDispatcher("footer.html").include(request, response);
		out.close();
	}

}
