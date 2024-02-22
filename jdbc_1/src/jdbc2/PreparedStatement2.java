package jdbc2;
import java.sql.*;
import java.util.Scanner;

public class PreparedStatement2 {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1?user=root&password=root");
		String createTable = "CREATE TABLE IF NOT EXISTS emp ("+"id INT AUTO_INCREMENT PRIMARY KEY,"+"name VARCHAR(255),"+"age INT)";
		PreparedStatement ps = con.prepareStatement("insert into emp values(?,?,?)");
		//Statement stm = con.createStatement();
		//stm.executeUpdate(createTable);
		//System.out.println("table created successfully");
		
//		do {
//			System.out.println("enter id:");
//			int id = sc.nextInt();
//			
//			System.out.println("enter name");
//			String name = sc.next();
//			System.out.println("enter age");
//			int age = sc.nextInt();
//			
//			
//			ps.setInt(1, id);
//			ps.setString(2, name);
//			ps.setInt(3,age);
//			int i = ps.executeUpdate();
//			System.out.println(i + " records affected");
//			
//			System.out.println("do you want to contionue: y/n");
//			String option = sc.next();
//			if(option.charAt(0) == 'n') {
//				break;
//			}
//		}while(true);
//		ps.executeUpdate("alter table emp add column salary DECIMAL(10,2)");
//		System.out.println("column added");
		//PreparedStatement ps1 = con.prepareStatement("update emp set salary = ? where id = ?");
		PreparedStatement ps1 = con.prepareStatement("update emp set salary = ? where name = ?");
		PreparedStatement ps2 = con.prepareStatement("select * from emp");
//		ps1.setInt(1, 1200);
//		ps1.setInt(2, 1);
		int[] salaries = {1300,2200,3200,200};
		int[] ids = {2, 3, 4, 5};
//		for(int i = 0; i < salaries.length; i++) {
//			ps1.setInt(1,  salaries[i]);
//			ps1.setInt(2,  ids[i]);
//		   ps1.executeUpdate();
//		}
		//ResultSet res = ps2.executeQuery();
		//System.out.println(res);
//		while(res.next()) {
//			String name = res.getString("name");
//			if(name.equalsIgnoreCase("muzamil")){
//				ps1.setInt(1, 40000);
//				ps1.setString(2,  name);
//				ps1.execute();
//				
//			}
//		}
		PreparedStatement ps3 = con.prepareStatement("select * from emp where name = ? and id = ?");
		ResultSet res1 = ps2.executeQuery();
		while(res1.next()) {
			String name = res1.getString("name");
			int age = res1.getInt(3);
			int id = res1.getInt(1);
			//String email = res.getString("email");
			if(name.equalsIgnoreCase("muzamil") && age == 24) {
				System.out.println("Employee details: " + res1.getInt(1) + " " + name + " " + res1.getString("salary"));
				ps3.setString(1, name);
				ps3.setInt(2,  id);
			}
		}
		con.close();
	}
}
