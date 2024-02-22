package servlet_demo;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet("/cycle")
public class LifeCycleOfServlet extends GenericServlet {
	static {
		System.out.println("LifCycleOfServlet class loading");
	}
	
	public LifeCycleOfServlet() {
		System.out.println("instant phase");
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("init phase");
	}
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		int i = 0;
		System.out.println("service phase " + (++i));
	}
	
	
	@Override
	public void destroy() {
		System.out.println("destory");
	}

	
}
