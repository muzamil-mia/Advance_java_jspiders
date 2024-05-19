package one_to_many_uni.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import one_to_many_uni.dto.Person;
import one_to_many_uni.dto.SocialMedia;

public class SocialMediaDAO {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("muzamil");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();
	public void saveSocial(int id, List<SocialMedia> list) {
		Person person = em.find(Person.class, id);
		person.setList(list);
		et.begin();
		em.persist(person);
		et.commit();
	}
}
 