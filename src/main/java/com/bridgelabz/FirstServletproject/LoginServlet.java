package com.bridgelabz.FirstServletproject;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(
		description = "Login Servlet Testing",
		urlPatterns = {"/LoginServlet"},

		initParams = {
				@WebInitParam(name = "user", value = "Pooja"),
				@WebInitParam(name = "pwd", value = "PAvhad@7")
		})


public class LoginServlet extends HttpServlet {
	@Override
	protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get request parameters for userID and password
		String user = request.getParameter("user"); 
		String pwd = request.getParameter("pwd");
		//get servlet config init params
		String userID = getServletConfig().getInitParameter("user"); 
		String password = getServletConfig().getInitParameter("pwd");

		if(userID.equals(user) && password.equals(pwd)) { 
			request.setAttribute("user", user);
			request.getRequestDispatcher("LoginSuccess.jsp").forward(request, response);
		} else {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/Login.html");
			PrintWriter out= response.getWriter();
			out.println("<font color=red>Either user name or password is wrong.</font>"); 
			rd. include (request, response);
		}
	}
}