package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.mysql.cj.Query;

import dto.User;

public class StudentCrud {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("muzamil");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction et = entityManager.getTransaction();
	public void saveStudent(User user) {
		et.begin();
		entityManager.persist(user);
		et.commit();
	}
	public User loginStudent(String email) {
		User user = entityManager.find(User.class, email);
		if(user != null) {
				return user;
			}
		return null;
	}
	
	public boolean deleteProfile(String email) {
		User student = entityManager.find(User.class, email);
		if(student != null) {
			et.begin();
			entityManager.remove(student);
			et.commit();
			System.out.println("deleted successfully");
			return true;
		}
		return false;
	}
	public void updateProfile(User user) {
		User student = entityManager.find(User.class, user.getEmail());
		if(student != null) {
			et.begin();
			entityManager.merge(user);
			et.commit();
		}
	}
	
}
