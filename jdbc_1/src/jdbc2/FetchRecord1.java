package jdbc2;
import java.sql.*;
public class FetchRecord1 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sonoo?user=root&password=root");
		Statement stm = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		ResultSet rs = stm.executeQuery("select * from emp");
//		while(rs.next()) {
//			System.out.println(rs.getInt(1));
//		}
		rs.absolute(2);
		System.out.println(rs.getInt(1)+ " " + rs.getString(2)+" "+rs.getString(3));
		
		con.close();
	}
}
