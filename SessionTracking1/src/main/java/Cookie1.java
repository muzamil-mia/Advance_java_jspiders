import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookie1")

public class Cookie1 extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(req.getParameter("email"));
		System.out.println(req.getParameter("password"));
		PrintWriter writer = resp.getWriter();
		writer.print("user added successfully");
		
		Cookie cookie = new Cookie("cookieemail", req.getParameter("email"));
		resp.addCookie(cookie);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("cookie2.html");
		dispatcher.forward(req, resp); 
	}
}
