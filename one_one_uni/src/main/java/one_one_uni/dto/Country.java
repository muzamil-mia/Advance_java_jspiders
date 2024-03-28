package one_one_uni.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
public class Country {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private long population;
	private String nb;
	private String na;
	
	@OneToOne
	private PrimeMinister pm;
	public Country(String name, long population, String nb, String na) {
		this.name = name;
		this.population = population;
		this.nb = nb;
		this.na = na;
	}
}
