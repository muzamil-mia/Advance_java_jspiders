package com.jsp.emp_servlet.employee.controller;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet("/save")
public class RegisterEmployee extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse arg1) throws ServletException, IOException {
		String name = req.getParameter("name");
		System.out.println(name);
		String mail = req.getParameter("mail");
		String phone = req.getParameter("phone");
		String pwd = req.getParameter("password");
		String age = req.getParameter("age");
		String desig = req.getParameter("designation");
		String sal = req.getParameter("sal");
		
		
		
	}
	
}
