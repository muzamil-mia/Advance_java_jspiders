package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import controller.User;
import dto.Customer;
import dto.Gadget;

public class UserCrud {
	static Scanner sc = new Scanner(System.in);
	public void createTable() {
		Connection con = Database.getConnection();
		try {
			Statement stm = con.createStatement();
			stm.execute("create table if not exists customer(email varchar(45), password varchar(45), wallet double)");
			stm.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void registerUser(Customer customer) {
		Connection con = Database.getConnection();
		try {
			PreparedStatement checkStmt = con.prepareStatement("select * from student where eamil = ?");
			checkStmt.setString(1,customer.getEmail());
			ResultSet res = checkStmt.executeQuery();
			while(res.next()) {
				System.out.println("user laready exists");
				return;
			}
			PreparedStatement ps = con.prepareStatement("insert into customer values(?,?,?)");
			ps.setString(1, customer.getEmail());
			ps.setString(2, customer.getPwd());
			ps.setDouble(3, customer.getWallet());
			ps.execute();
			ps.close();
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public boolean chooseLogin(String mail, String pwd) {
		System.out.println("checking login details");
		Connection con = Database.getConnection();
		try {
			Statement stm = con.createStatement();
			ResultSet res = stm.executeQuery("select * from customer");
			if(!res.next()) {
				System.out.println("no data found");
				User.registerUser();
			}else {
				do {
					String email = res.getString(1);
					String password = res.getString(2);
					if(email.equalsIgnoreCase(mail) && password.equalsIgnoreCase(pwd)) {
						stm.close();
						con.close();
						return true;
					}
				}while(res.next());
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public void addGadgets(List<Gadget> list) {
		Connection con = Database.getConnection();
		try {
			 PreparedStatement ps = con.prepareStatement("insert into gadgets values(?,?,?)");
			 for(Gadget gad : list) {
				 ps.setInt(1, gad.getId());
				 ps.setString(2, gad.getPhoneName());
				 ps.setDouble(3, gad.getPrice());
				 ps.addBatch();
			 }
			 ps.executeBatch();
			 ps.close();
			 con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
//	
	public void showItems(String email) {
		Connection con = Database.getConnection();
		try {
			Statement stm = con.createStatement();
			ResultSet res = stm.executeQuery("select * from gadgets");
			while(res.next()) {
				System.out.println(res.getInt(1) + " " + res.getString(2)+ " "+ res.getDouble(3));
			}
			stm.close();
			res.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Want to buy any item \n 1.Yes \n 2. No");
		int slno = sc.nextInt();
		boolean choice  = false;
		if(slno == 1) {
			choice = true;
			System.out.println("enter the id of phone you want to buy");
			int id = sc.nextInt();
			System.out.println("preparing your order");
			proceedPurchase(email, id);
		}
	}
	private void proceedPurchase(String email, int id) {
	Connection con = Database.getConnection();
	Double price = 0.0;
	try {
		PreparedStatement ps = con.prepareStatement("select * from gadgets where slno = ?");
		ps.setInt(1, id);
		ResultSet res = ps.executeQuery();
		if(res.next()) {
			System.out.println(res.getInt(1) + " " + res.getString(2) + " " + res.getDouble(3));
			int slno = res.getInt(1);
			String name = res.getString(2);
			price = res.getDouble(3);
			Gadget gadget = new Gadget(slno, name, price);
			updateCustomerWallet(email, price);
		}else {
			System.out.println("no such item");
		}
		res.close();
		ps.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	public void updateCustomerWallet(String email, double price) {
		Connection con = Database.getConnection();
		try {
			 PreparedStatement ps = con.prepareStatement("select * from customer where email = ?");
			 ps.setString(1, email);
			 ResultSet res = ps.executeQuery();
			 if(res.next()) {
				// System.out.println(" i am a customer");
				 double currentBalance = res.getDouble(3);
				 System.out.println(currentBalance);
				 if(currentBalance < price) {
					 System.out.println("insufficient balance please add money to wallet");
					double newAmount = updateWallet() + res.getDouble(3);
					 PreparedStatement updateStatement = con.prepareStatement("update customer set wallet = ? where email = ?");
					 updateStatement.setDouble(1, newAmount);
					 updateStatement.setString(2, email);
					 System.out.println("wallet updated successfully");
					 updateStatement.execute();
					 System.out.println("buy now");
					 showItems(email);
				 }else {
					 double newWalletAmount = res.getDouble(3) - price;
					 //System.out.println(newWalletAmount);
					 PreparedStatement updateStatement = con.prepareStatement("update customer set wallet = ? where email = ?");
					 updateStatement.setDouble(1, newWalletAmount);
					 updateStatement.setString(2, email);
					 System.out.println("wallet updated successfully");
					 updateStatement.execute();
//					 double amount = res.getDouble(4);
//					 System.out.println(amount);
				 }
			 }else {
				 System.out.println("customer not found with particular email");
			 }
			 ps.execute();
			 ps.close();
			 con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private double updateWallet() {
		System.out.println("enter the amount you want to add to wallet");
		double amount = sc.nextDouble();
		return amount;
	}
}


