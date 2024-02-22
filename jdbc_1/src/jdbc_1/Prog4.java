package jdbc_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;
import java.sql.Statement;

public class Prog4 {

	public static void main(String[] args) {
		//load and register
		
		try {
			DriverManager.registerDriver(new Driver());
			//Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1?user=root&password=root");
			
			Statement s = con.createStatement();
			s.execute("update table1 set name = 'hussian' where slno = 1");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("done....");
	}
}
