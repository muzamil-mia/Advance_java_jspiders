package com.tcs;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		
		//get the requested data
	 	String username = request.getParameter("username");
	 	String password = request.getParameter("password");
	 	
	 	//request processing logics (ist way)
	 /*	if((username.equalsIgnoreCase("muzamil")) && (password.equals("muzamil@123"))) {
	 	    response.sendRedirect("http://www.tcs.com");
	 	} else {
	 	    response.sendError(808,"login fail try with valid data");
	 	}
	}
	*/
	 	
	 	//second way
	 	/*
	 	if(username.equalsIgnoreCase("muzamil") && password.equals("muzamil@123")) {
	 		RequestDispatcher dispatcher = request.getRequestDispatcher("loginSuccess.html");
	 		dispatcher.forward(request, response);
	 	}else {
	 		RequestDispatcher dispatcher = request.getRequestDispatcher("loginFailed.html");
	 		dispatcher.forward(request, response);
	 	}
	}	
	*/
	 	
	 	//third way
	 	if(username.equalsIgnoreCase("muzamil") && password.equals("muzamil@123")) {
	 		writer.println("<a href = 'http://www.facebook.com'>click here to go to facebook page</a>");
	 	}else {
	 		writer.println("<a href = 'FailedServlet'>click here to go to fail information</a>");
	 	}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
