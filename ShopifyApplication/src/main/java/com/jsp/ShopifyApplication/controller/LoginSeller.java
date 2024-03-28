package com.jsp.ShopifyApplication.controller;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.ShopifyApplication.dao.SellerDAO;
import com.jsp.ShopifyApplication.dto.SellerDTO;


@WebServlet("/loginSeller")
public class LoginSeller extends HttpServlet {
       SellerDAO crud = new SellerDAO();
    
    public LoginSeller() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		SellerDTO seller = crud.fetchSellerByMail(email);
		if(seller != null) {
			System.out.println(seller.getPassword());
			if(seller.getPassword().equals(password)) {
				request.setAttribute("seller", seller);
				RequestDispatcher dispatcher = request.getRequestDispatcher("sellerHome.jsp");
				dispatcher.forward(request, response);
			}else {
				System.out.println("wrong password");
			}
		}else {
			System.out.println("wrong email");
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
