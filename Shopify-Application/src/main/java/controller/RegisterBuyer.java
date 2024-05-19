package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BuyerDAO;
import dto.BuyerDTO;

@WebServlet("/registerbuyer")
public class RegisterBuyer extends HttpServlet  {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String firstName = req.getParameter("first-name");
		String lastName = req.getParameter("last-name");
		String email = req.getParameter("email");
		String password = req.getParameter("pwd");
		String phoneString = req.getParameter("phone");
		String address = req.getParameter("address");
		String walletString = req.getParameter("wallet");
		long phone = 0;
		double wallet = 0.0;
		
		try {
			if(phoneString != null && !phoneString.isEmpty()) {
				phone = Long.parseLong(phoneString);
			}
			if(walletString != null && !walletString.isEmpty()) {
				wallet = Double.parseDouble(walletString);
			}
		}catch(NumberFormatException e) {
			System.out.println("invalid data");
		}
		
		BuyerDTO buyer = new BuyerDTO(firstName, lastName, email, password, phone, wallet, address);
		BuyerDAO crud = new BuyerDAO();
		if(crud.registeBuyer(buyer)) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("./index.jsp");
			dispatcher.forward(req, resp);
		}
	}
}

