package one_to_many_uni.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import one_to_many_uni.dao.PersonDAO;
import one_to_many_uni.dao.SocialMediaDAO;
import one_to_many_uni.dto.Person;
import one_to_many_uni.dto.SocialMedia;

public class Main {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("Choose the options \n 1. Person \n 2. Social \n 3. Exit ");
		int option = sc.nextInt();
		boolean flag = true;
		while (flag) {
			switch (option) {
			case 1:
				person();
				break;
			case 2:
				saveSocial();
				break;
			case 3:
				flag = false;
				break;
			default:
				System.out.println("enter the valid option");
			}
		}
	}

	private static void saveSocial() {
		System.out.println("enter the id of the person you want to add social for");
		int id = sc.nextInt();
		List<SocialMedia> list = new ArrayList<>();
		SocialMedia social = getAccountDetails();
		if (social != null) {
			list.add(social);
		}
		boolean flag = true;
		while (flag) {
			System.out.println("add another account?");
			System.out.println("1. Yes \n 2. No");
			int option = sc.nextInt();
			switch (option) {
			case 1:
				SocialMedia social1 = getAccountDetails();
				if (social1 != null) {
					list.add(social1);
				}
				break;
			case 2: flag = false;
			break;
			default: System.out.println("enter right option");
			}
		}
		SocialMediaDAO dao = new SocialMediaDAO();
		dao.saveSocial(id, list);
	}

	private static void person() {
		System.out.println("Choose the options \n 1. Save \n 2. Update \n 3. Delete \n 4. Fetch \n 5. Exit");
		int option = sc.nextInt();
		boolean flag = true;
		while (flag) {
			switch (option) {
			case 1:
				save();
				break;
			case 2:
				updatePerson();
				break;
			case 3:
				deletePerson();
				break;
			case 4:
				fetchPerson();
				break;
			case 5:
				flag = false;
			}
		}
	}

	private static void fetchPerson() {
		// TODO Auto-generated method stub

	}

	private static void deletePerson() {
		// TODO Auto-generated method stub

	}

	private static void updatePerson() {
		// TODO Auto-generated method stub

	}

	private static void save() {
		System.out.println("choose below option \n 1. Person \n 2. Person With Social \n 3. Exit");
		int option = sc.nextInt();
		boolean flag = true;
		while (flag) {
			switch (option) {
			case 1:
				savePerson();
				break;
			case 2:
				saveSocial();
				break;
			case 3:
				flag = false;
			}
		}
	}

	private static void savePersonWithSocial() {
		// TODO Auto-generated method stub

	}

	private static void savePerson() {
		System.out.println("enter your name");
		String name = sc.next();
		System.out.println("enter your email");
		String email = sc.next();
		System.out.println("enter your gender");
		String gender = sc.next();
		System.out.println("enter your age");
		int age = sc.nextInt();
		Person person = new Person();
		person.setName(name);
		person.setEmail(email);
		person.setAge(age);
		person.setGender(gender);
		PersonDAO personCrud = new PersonDAO();
		List<SocialMedia> list = new ArrayList<>();
		// personCrud.savePerson(person);
		System.out.println("you want to add social account also?");
		System.out.println("1. Yes \n 2. No");
		int option = sc.nextInt();
		boolean flag = true;
		while (flag) {
			switch (option) {
			case 1:
				SocialMedia social = getAccountDetails();
				if (social != null) {
					list.add(social);
					boolean flag2 = true;
					while (flag2) {
						System.out.println("add another account? \n 1. Yes \n 2. No");
						int option1 = sc.nextInt();
						switch (option1) {
						case 1:
							SocialMedia social1 = getAccountDetails();
							if (social1 != null) {
								list.add(social1);
							}
							break;
						case 2:
							person.setList(list);
							personCrud.savePerson(person);
							flag2 = false;
							flag = false;
							break;
						default:
							System.out.println("choose correct option");
						}
					}
				}
				break;
			case 2:
				personCrud.savePerson(person);
				flag = false;
				break;
			default:
				System.out.println("enter valid option");
			}
		}
	}

	private static SocialMedia getAccountDetails() {
		System.out.println("enter platorm");
		String platform = sc.next();
		System.out.println("enter the user name");
		String userName = sc.next();
		System.out.println("enter your email");
		String mail = sc.next();
		SocialMedia social = new SocialMedia();
		social.setPlatform(platform);
		social.setUserName(userName);
		social.setEmail(mail);
		return social;
	}

	private static SocialMedia saveAccount() {
		System.out.println("enter platform name");
		String platform = sc.next();
		System.out.println("enter your user name");
		String user = sc.next();
		System.out.println("enter your email");
		String email = sc.next();
		System.out.println("enter your assword");
		String pwd = sc.next();
		SocialMedia media = new SocialMedia();
		media.setPlatform(platform);
		media.setUserName(user);
		media.setEmail(email);
		media.setPassword(pwd);
		return media;
	}
}
