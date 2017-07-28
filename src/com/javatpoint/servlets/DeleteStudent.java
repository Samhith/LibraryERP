package com.javatpoint.servlets;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javatpoint.beans.StudentBean;
import com.javatpoint.dao.StudentDao;
@WebServlet("/DeleteStudent")
public class DeleteStudent extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.println("<head>");
		out.println("<title>Student List</title>");
		out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
		out.println("</head>");
		out.println("<body>");
		
		request.getRequestDispatcher("navlibrarian.html").include(request, response);
		out.println("<div class='container'>");
		
		List<StudentBean> list1 = StudentDao.view();
		
		out.println("<table class='table table-bordered table-striped'>");
		out.println("<th>Name</th><th>Email</th><th>Mobile</th><th>Delete</th></tr>");
		for(StudentBean bean:list1){
			System.out.println(bean.getId());
			out.println("</td><td>"+bean.getName()+"</td><td>"+bean.getEmail()+"</td><td>"+bean.getMobile()+"</td><td><a href='DeleteStudent1?mail="+bean.getEmail()+"'>Delete</a></td></tr>");
		}
		out.println("</table>");
		
		out.println("</div>");
		request.getRequestDispatcher("footer.html").include(request, response);
		out.close();
		
	}
}
