package servlet_demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/sub")
public class Subtraction extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		int value1 = Integer.parseInt(req.getParameter("num1"));
		int value2 = Integer.parseInt(req.getParameter("num2"));
		int value3 = Integer.parseInt(req.getParameter("num3"));
		int total = value1 - value2 - value3;
		PrintWriter writer = res.getWriter();
		writer.println("<h1 bgcolor = 'pink'>" +total+ "</h1>");

	}

}
