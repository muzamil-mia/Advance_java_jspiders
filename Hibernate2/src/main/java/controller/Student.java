package controller;

import javax.persistence.Persistence;

import dao.StudentCrud;
import dto.StudentDTO;
import dto.StudentIdentity;

class Student {
	public static void main(String[] args) {
		StudentCrud crud = new StudentCrud();
		StudentDTO student = new StudentDTO("muzamil", "hussainmuzamil@gmail.com", "muzamil@123", 75.5);
		crud.saveStudent(student);
		StudentIdentity si = new StudentIdentity("hussain", "hussainmuzamil@gmail.com", "muzamil@123", 75.5);
		crud.saveStudentIdentity(si);
	}
}
