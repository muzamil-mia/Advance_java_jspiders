package jdbc2;
import java.sql.*;
public class FetchRecord {

	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sonoo?user=root&password=root");
		Statement stm = con.createStatement();
		System.out.println("welcome");
		//stm.execute("insert into emp values(1, 'muzamil', 24)");
		//stm.execute("insert into emp values(2, 'sabit', 25)");
		//stm.execute("insert into emp values(3, 'rahul', 23)");
		int result = stm.executeUpdate("delete from emp where id = 1");
		System.out.println(result + " records affected");
		con.close();
	}

}
