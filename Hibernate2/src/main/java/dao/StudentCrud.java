package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dto.StudentDTO;
import dto.StudentIdentity;

public class StudentCrud {
	EntityManager em = Persistence.createEntityManagerFactory("muzamil").createEntityManager();
	EntityTransaction et = em.getTransaction();

	public void saveStudent(StudentDTO student) {
		et.begin();
		em.merge(student);
		et.commit();
	}
	public void saveStudentIdentity(StudentIdentity si) {
		et.begin();
		em.merge(si);
		et.commit();
	}
}
