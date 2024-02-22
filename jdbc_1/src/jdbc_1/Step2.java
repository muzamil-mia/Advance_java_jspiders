package jdbc_1;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Step2 {

	public static void main(String[] args) {
		
		
		try {
			//load and register
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//establish the connection
			DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root", "root");
			System.out.println("welcome");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
