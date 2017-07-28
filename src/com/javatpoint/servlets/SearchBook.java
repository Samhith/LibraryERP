package com.javatpoint.servlets;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javatpoint.beans.BookBean;
import com.javatpoint.beans.StudentBean;
import com.javatpoint.dao.BookDao;
import com.javatpoint.dao.StudentDao;
@WebServlet("/SearchBook")
public class SearchBook extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bname=request.getParameter("bookname");
		
		List<BookBean> list1 = BookDao.viewByName(bname);
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.println("<head>");
		out.println("<title>Student List</title>");
		out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
		out.println("</head>");
		out.println("<body>");
		
		request.getRequestDispatcher("navstudent.html").include(request, response);
		out.println("<div class='container'>");
		out.println("<table class='table table-bordered table-striped'>");
		out.println("<th>Name</th><th>Author</th><th>Publisher</th></tr>");
		for(BookBean bean:list1){
			System.out.println(bean.getCallno());
			out.println("</td><td>"+bean.getName()+"</td><td>"+bean.getAuthor()+"</td><td>"+bean.getPublisher()+"</td><td></tr>");
		}
		out.println("</table>");
		
		out.println("</div>");
		request.getRequestDispatcher("footer.html").include(request, response);
		out.close();
		
		
		
	}
}
