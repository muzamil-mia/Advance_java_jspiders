package one_to_one.dao;

import javax.persistence.CascadeType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.OneToOne;
import javax.persistence.Persistence;

import one_to_one.dto.PanCard;
import one_to_one.dto.Person;

public class PersonDAO {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("muzamil");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();

	public void savePerson(Person person) {
		et.begin();
		em.persist(person);
		et.commit();
		System.out.println("person saved successfully");
	}

	public Person fetchPerson(int id) {
		return em.find(Person.class, id);
	}

	public boolean deletePerson(int id) {
		Person person = em.find(Person.class, id);
		if(person != null) {
			et.begin();
			em.remove(person);
			et.commit();
			return true;
		}else {
			System.out.println("no such person found");
		}
		return false;
	}

	public void savePersonWithPan(Person person) {
		et.begin();
		//before saving person we need to save the pan i.e before saving owning entity we need to store non-owning entity 
	    //otherwise we get the exception -> TransientPropertyValueException
		//so again there is a problem here that is code repetation if i have n number of non-owning entity 
		//i need to write n number of persist methods which is not good 
		//so to overcome this problem we have @Cascading annotation
		
		//@OneToOne(cascade = CascadeType.PERSIST) so here cascade will transfer DML operation from ow  ning to non-owning
		//private PanCard panCard;
		
		em.persist(person.getPanCard());
		em.persist(person);
		et.commit();
	}
}
