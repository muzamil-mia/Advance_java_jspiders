package jdbc2;
import java.sql.*;
import java.util.Scanner;

public class PreparedStatement1 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1?user=root&password=root");
		//PreparedStatement ps = con.prepareStatement("insert into table1 values(6, 'ajay', 'ajay@gmail', 9192634)");
		//System.out.println(ps);
		//int res = ps.executeUpdate();
		//con.close();
		System.out.println("inserted");
		//Scanner sc = new Scanner(System.in);
//		System.out.println("enter the number ");
//		int n = sc.nextInt();
		PreparedStatement ps = con.prepareStatement("insert into table1 values(?,?,?,?)");
		Scanner sc = new Scanner(System.in);
//		System.out.println("enter the number of users");
//		int n = sc.nextInt();
//		for(int i = 0; i < n; i++) {
//			System.out.println("enter the slno");
//			int slno = sc.nextInt();
//			System.out.println("enter the name");
//			String name = sc.next();
//			System.out.println("enter the email");
//			String mail = sc.next();
//			System.out.println("enter the phone number");
//			int phone = sc.nextInt();
//			ps.setInt(1,slno);
//			ps.setString(2, name);
//			ps.setString(3, mail);
//			ps.setInt(4, phone);
//			int res = ps.executeUpdate();
//			System.out.println("inserted " + res + " no. of rows");
//		}
		PreparedStatement ps1 = con.prepareStatement("update table1 set name = ? where slno = ?");
		
//		System.out.println("enter the name yow want to update");
//		String name = sc.next();
//		System.out.println("enter the slno you want to update at");
//		int slno = sc.nextInt();
//		ps1.setString(1, name);
//		ps1.setInt(2, slno);
//		int i = ps1.executeUpdate();
//		System.out.println(i +" number of records effected");
		PreparedStatement ps2 = con.prepareStatement("delete from table1 where slno = ?");
		ps2.setInt(1,  1);
		ps2.execute();
		PreparedStatement ps3 = con.prepareStatement("select * from table1");
		ResultSet res = ps3.executeQuery();
		while(res.next()) {
			System.out.println(res.getString(2));
		}
		con.close();
	}

}
