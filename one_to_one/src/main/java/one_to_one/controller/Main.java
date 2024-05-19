package one_to_one.controller;

import java.sql.Date;
import java.util.Scanner;

import one_to_one.dao.PanDAO;
import one_to_one.dao.PersonDAO;
import one_to_one.dto.PanCard;
import one_to_one.dto.Person;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static PanDAO panCrud = new PanDAO();
	static PersonDAO personCrud = new PersonDAO();

	public static void main(String[] args) {
		System.out.println("==============Welocome Here================");
		System.out.println(
				"Choose the options to save details \n 1. Save Person \n 2. Save PAN \n 3. Display Person \n 4. Deleter Person \n 5. Pan Details \n 6. Exit \n 7. Delete Pan");
		int option = sc.nextInt();
		boolean flag = true;
		while (flag) {
			switch (option) {
			case 1:
				handleSavePerson();
				break;
			case 2:
				handleSavePAN();
				break;
			case 3:
				showPerson();
				break;
			case 4:
				deletePerson();
				break;
			case 5:
				panDetails();
				break;
			case 6:
				flag = false;
				break;
			case 7:
				deletePersonPan();
				break;
			default:
				System.out.println("invalid please choose in the above options");
			}
		}
	}

	private static void deletePersonPan() {
		System.out.println("enter the pancard id");
		int id = sc.nextInt();
		panCrud.deletePersonPan(id);
	}

	private static void deletePerson() {
		System.out.println("enter the id of the person you want to delete");
		int id = sc.nextInt();
		if(personCrud.deletePerson(id)) {
			System.out.println("person deleted successfully");
		};
	}

	private static void panDetails() {
		System.out.println("enter the id of the person");
		int id = sc.nextInt();
		PanCard pan = panCrud.fetchPanDetails(id);
		if (pan != null) {
			System.out.println(pan);
		} else {
			System.out.println("pan with given id is not found");
		}
	}

	private static void showPerson() {
		System.out.println("enter the id of person");
		int id = sc.nextInt();
		Person person = personCrud.fetchPerson(id);
		if (person != null) {
			System.out.println(person);
		} else {
			System.out.println("no such person present");
		}
	}

	private static void handleSavePAN() {
		System.out.println("enter the id of the person you want to save pan for");
		int id = sc.nextInt();
		System.out.println("enter the pan number");
		String panNumber = sc.next();
		System.out.println("enter the father name");
		String fatherName = sc.next();
		System.out.println("enter your name");
		String name = sc.next();
		System.out.println("enter your date of birth");
		String dob = sc.next();
		Date DOB = Date.valueOf(dob);
		PanCard panCard = new PanCard(panNumber, fatherName, name, DOB);
		panCrud.savePan(panCard, id);
	}

	private static void handleSavePerson() {
		System.out.println("choose below option \n 1. Person without PAN \n 2. Person with PAN");
		int option = sc.nextInt();
		switch (option) {
		case 1:
			savePersonDetails();
			break;
		case 2:
			savePersonWithPANDetails();
			break;
		}
	}

	private static void savePersonWithPANDetails() {
		Person person = new Person("zakir malik", "zakir@gmail", 123456234l, 22);
		PanCard pan = new PanCard("123qwer","ghnabi","zakirmalik",Date.valueOf("1998-02-01"));
		person.setPanCard(pan);
		personCrud.savePersonWithPan(person);
	}

	private static void savePersonDetails() {
		System.out.println("enter the name");
		String name = sc.next();
		System.out.println("enter the email");
		String email = sc.next();
		System.out.println("enter the phone number");
		long phone = sc.nextLong();
		System.out.println("enter the age");
		int age = sc.nextInt();
		Person person = new Person(name, email, phone, age);
		PersonDAO crud = new PersonDAO();
		crud.savePerson(person);
	}
}
