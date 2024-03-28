package one_to_many_uni.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Country1 {
	
	public Country1(String name, long population, String nb, String na, ArrayList<State> list) {
		this.name = name;
		this.population = population;
		this.nb = nb;
		this.na = na;
		this.states = list;
	}

	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private long population;
	private String nb;
	private String na;
	
	@OneToMany(cascade = CascadeType.ALL)
	List<State> states;
}
