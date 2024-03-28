package one_to_many_uni.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class State {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String cm;
	private int districts;
	private String language;
	
	public State(String name, String cm, int districts, String language) {
		this.name = name;
		this.cm = cm;
		this.districts = districts;
		this.language = language;
	}
}
