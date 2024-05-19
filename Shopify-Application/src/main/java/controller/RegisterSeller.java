package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SellerDAO;
import dto.SellerDTO;

public class RegisterSeller extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String firstName = req.getParameter("first-name");
		String lastName = req.getParameter("last-name");
		String email = req.getParameter("email");
		String password= req.getParameter("password");
		String phoneString = req.getParameter("phone");
		String address = req.getParameter("address");
		long phone = 0;
		try {
			if(phoneString != null && !phoneString.isEmpty()) {
				phone = Long.parseLong(phoneString);
			}
		}catch(NumberFormatException e) {
			System.out.println(e);
		}
		SellerDTO seller = new SellerDTO(firstName, lastName, email, password, phone, address);
		SellerDAO sellerCrud = new SellerDAO();
		if(sellerCrud.registerSeller(seller)) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
			dispatcher.forward(req, resp);
		};
	}
}
