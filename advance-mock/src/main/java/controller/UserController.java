package controller;

import java.util.Scanner;

import dao.StudentCrud;
import dto.User;

public class UserController {
static Scanner sc = new Scanner(System.in);
static StudentCrud crud = new StudentCrud();
	public static void main(String[] args) {
		System.out.println("Hello students");
		homePage();
	}

	private static void homePage() {
		System.out.println("choose the below option");
		System.out.println("1 -> new user");
		System.out.println("2 -> login");
		int option = sc.nextInt();
		switch(option) {
		case 1:{
			User user = registerDetails();
			crud.saveStudent(user);
			loginDetails();
		}
		break;
		case 2: loginDetails();
		}
	}

	private static void loginDetails() {
		System.out.println("enter your email");
		String email = sc.next();
		System.out.println("enter your password");
		String pwd = sc.next();
		User user = crud.loginStudent(email);
		if(user != null) {
			if(user.getPassword().equals(pwd)) {
				System.out.println("login succesfull");
				proceedFurther();
			}else {
				System.out.println("wrong password");
			}
		}else {
			System.out.println("wrong email");
		}
	}

	private static void proceedFurther() {
		System.out.println("choose below options");
		System.out.println("1 -> update the profile");
		System.out.println("2 -> Delete the profile");
		int option = sc.nextInt();
		switch(option) {
		case 1: updateProfile();
		break;
		case 2: deleteProfile();
		break;
		}
	}

	private static void deleteProfile() {
		System.out.println("neter your email");
		String email = sc.next();
		boolean flag =crud.deleteProfile(email);
		if(flag) {
			homePage();
		}
	}

	private static void updateProfile() {
		User user = new User();
		System.out.println("enter your name");
		user.setName(sc.next());
		System.out.println("enter you email");
		user.setEmail(sc.next());
		System.out.println("enter the password");
		user.setPassword(sc.next());
		System.out.println("enter your mrks");
		user.setMarks(sc.nextDouble());
		System.out.println("enter your branch");
		user.setBranch(sc.next());
		crud.updateProfile(user);
	}


	private static User registerDetails() {
		User user = new User();
		System.out.println("enter student id");
		user.setId(sc.nextInt());
		System.out.println("enter your name");
		user.setName(sc.next());
		System.out.println("enter you email");
		user.setEmail(sc.next());
		System.out.println("enter the password");
		user.setPassword(sc.next());
		System.out.println("enter your mrks");
		user.setMarks(sc.nextDouble());
		System.out.println("enter your branch");
		user.setBranch(sc.next());
		return user;
	}

}
