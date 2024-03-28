package com.jsp.ShopifyApplication.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.ShopifyApplication.dao.SellerDAO;
import com.jsp.ShopifyApplication.dto.SellerDTO;

@WebServlet("/registerseller")
public class RegisterSeller extends HttpServlet {
	
	public RegisterSeller() {
		super();
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String firstName = req.getParameter("first-name");
		System.out.println(firstName);
		String lastName = req.getParameter("last-name");
		String email = req.getParameter("email");
		String password= req.getParameter("password");
		System.out.println(password);
		String phoneString = req.getParameter("phone");
		String address = req.getParameter("address");
		long phone = 0;
		try {
			if(phoneString != null && !phoneString.isEmpty()) {
				phone = Long.parseLong(phoneString);
			}
		} catch (NumberFormatException e) {
			System.out.println("invalid phone number");
		}
		SellerDTO seller = new SellerDTO(firstName, lastName, email, password, phone, address);
		SellerDAO crud = new SellerDAO();
		if(crud.registerSeller(seller)) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("./index.jsp");
			dispatcher.forward(req, resp);
		}
	}	
}
