package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import dao.Database;
import dao.UserCrud;
import dto.Customer;
import dto.Gadget;

public class User {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		UserCrud crud = new UserCrud();
		crud.createTable();
		Connection con = Database.getConnection();
		boolean flag = true;
		do {
			System.out.println("Enter the option below \n 1. User \n 2. Gadget \n 3. Exit");
			int option = sc.nextInt();
			switch (option) {
			case 1: {
				System.out.println("choose to registe or login \n 1. Register \n 2.Login");
				int opt = sc.nextInt();
				switch (opt) {
				case 1:
					registerUser();
					break;
				case 2:
					if (!chooseToLogin()) {
						System.out.println("please register yourself");
						registerUser();
					}
					break;
				}
			}
				break;
			case 2: {
				System.out.println("enter your email");
				String mail = sc.next();
				crud.showItems(mail);
			}

				break;
			case 3:
				flag = false;
				System.out.println("thanks for using our application");
			}

		} while (flag);
	}

	public static void registerUser() {
		System.out.println("enter your eamil");
		String mail = sc.next();
		System.out.println("enter the password");
		String password = sc.next();
		System.out.println("enter the wallet amount");
		double wallet = sc.nextDouble();
		Customer customer = new Customer(mail, password, wallet);
		UserCrud crud = new UserCrud();
		crud.registerUser(customer);
		System.out.println("registered successfully please login now");
		if (chooseToLogin()) {
			System.out.println("login Successfull");

		}
		;
	}

	private static boolean chooseToLogin() {
		System.out.println("enter the email");
		String mail = sc.next();
		System.out.println("enter the password");
		String pwd = sc.next();
		UserCrud crud = new UserCrud();
		boolean login = crud.chooseLogin(mail, pwd);
		if (login) {
			// System.out.println("login successfull");
			crud.showItems(mail);
			return true;
		} else {
			System.out.println("you are not registered please register first");
			registerUser();
		}
		return false;
	}

}