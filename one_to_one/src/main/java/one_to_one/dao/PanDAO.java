package one_to_one.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import one_to_one.dto.PanCard;
import one_to_one.dto.Person;

public class PanDAO {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("muzamil");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();
	public void savePan(PanCard pan) {
		et.begin();
		em.persist(pan);
		et.commit();
		System.out.println("pan saved successfully");
	}
	public PanCard fetchPanDetails(int id) {
		return em.find(PanCard.class, id);
	}
	public void deletePerson(int id) {
		PanCard panCard = em.find(PanCard.class, id);
		if(panCard != null) {
			et.begin();
			em.remove(panCard);
			et.commit();
		}
	}
	
	public void savePan(PanCard panCard, int id) {
		Person person = em.find(Person.class, id);
		if(person != null) {
			et.begin();
			PanCard pan = em.merge(panCard);
			person.setPanCard(pan);
			et.commit();
		}
	}
	public void deletePersonPan(int id) {
		PanCard pan = em.find(PanCard.class, id);
		if(pan != null) {
			Query query = em.createQuery("SELECT p from Person p where p.panCard = :pan");
			query.setParameter("pan", pan);
			Person person = (Person) query.getSingleResult();
			person.setPanCard(null);
			et.begin();
			em.remove(pan);
			et.commit();
		}
	}
	
}
