package jdbc_2.controller;

import java.util.Scanner;

import jdbc_2.dao.StudentCrud;
import jdbc_2.dto.Student;

public class StudentMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StudentCrud stu = new StudentCrud();
		stu.createTable();
		System.out.println("=====welcome to my app======");
		boolean flag = true;
		
		//alt+shift+s shortcut

		do {
			System.out.println("enter the choices \n 1.save\n 2.update \n 3.delete \n 4.fetch \n 5.exit");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("enter the id of student");
				int id = sc.nextInt();
				System.out.println("enter the name of student");
				String name = sc.next();
				System.out.println("enter the email of user");
				String mail = sc.next();
				System.out.println("enter the phone number of student");
				long ph = sc.nextLong();
				System.out.println("enter the password of student");
				String pwd = sc.next();
				System.out.println("enter the marks of student");
				double marks = sc.nextDouble();
				System.out.println("done asking values and adding to constructor");
				//stu.updateTable(id, name, mail, ph, pwd, marks);
				Student student1 = new Student(id, name, mail, ph, pwd, marks);
				//System.out.println(student1);
				System.out.println("starting from controller");
				stu.saveStudent(student1);
				
				//System.out.println("data inserted successfully");
				break;
			case 2:
				System.out.println("enter the new name");
				String newName = sc.next();
				System.out.println("enter the id where you want to update");
				int id1 = sc.nextInt();
				Student student2 = new Student(id1, newName);
				stu.updateStudent(student2);
				//System.out.println("data updated successfully");
				break;
			case 3:
				System.out.println("enter the name of student you want to delete from table");
				String deleteName = sc.next();
				Student deleteStudent = new Student(deleteName);
				stu.deleteStudent(deleteStudent);
				System.out.println("data deleted succcessfully");
				break;
			case 4:
				stu.fetchStudents();
				System.out.println("data fetch successfully");
				break;
			case 5:
				flag = false;
				break;
			default:
				System.out.println("enter right choice");
			}

		} while (flag);
	}

}
