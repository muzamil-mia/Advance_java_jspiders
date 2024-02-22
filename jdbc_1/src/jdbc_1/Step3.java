package jdbc_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Step3 {

	public static void main(String[] args) {
		try {
			// load and register
			// Class.forName("com.mysql.cj.jdbc.Driver");

			// establish the connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root", "root");
			// local host is the name of the server hosting our database, 3306 is the port
			// number
			System.out.println("welcome");
			
			// creation of statement
			Statement s = con.createStatement();

			// execute of statement
			// s.execute("insert into table1 values(1, 'muzamil',
			// 'hussainmuzamil@gmail.com', 1234567890)");

			// close
			s.close();
			con.close();
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
