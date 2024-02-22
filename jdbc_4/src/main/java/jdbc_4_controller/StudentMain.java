package jdbc_4_controller;
 
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import jdbc_4_dao.StudentCrud;
import jdbc_4_dto.Student;

public class StudentMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StudentCrud stu = new StudentCrud();
		List<Student> list = new ArrayList<>();
//		list.add(new Student(8, "alok", "alok@gmail", 93764948, "alok@123", 60.5));
//		list.add(new Student())
		boolean flag = true;
		System.out.println("===========Welcome to my app=============");
		do {
			System.out.println("Enter the choice \n 1. Insert \n 2. Save \n 3. Update \n 4. Fetch \n 5. Exit");
			int n = sc.nextInt();
			switch(n) {
			case 1: System.out.println("inserted");
			System.out.println("enter the id of the student");
			int id = sc.nextInt();
			System.out.println("enter the name of the student");
			String name = sc.next();
			System.out.println("enter the email of a student");
			String mail = sc.next();
			System.out.println("enter the phone number of a student");
			long phone = sc.nextLong();
			System.out.println("enter the passsword of a student");
			String pwd = sc.next();
			System.out.println("enter the marks of a student");
			double marks = sc.nextDouble();
			Student student = new Student(id, name, mail, phone, pwd, marks);
			list.add(student);
//			stu.createBatch(list);
			break;
			case 2: stu.createBatch(list);
			list.clear();
			break;
			case 3: System.out.println("enter the new name");
			String newName = sc.next();
			System.out.println("enter the id");
			int id1 = sc.nextInt();
			Student updateStudent = new Student(newName, id1);
			list.add(updateStudent);
//			stu.updateStudent(list);
			break;
			case 4: stu.fetch();
			break;
			case 5: flag = false;
			break;
			default: System.out.println("enter the right choice");
			break;
			}
			
		}while(flag);
		//calling createBatch
		//stu.createBatch(list);
		stu.updateStudent(list);
		list.clear();
		
	}

	}
