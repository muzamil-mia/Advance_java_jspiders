package one_one_uni.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
public class PrimeMinister {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private int age;
	private String gender;
	private String partyName;
	public PrimeMinister(String name, String gender, int age, String partyName) {
		this.name= name;
		this.gender = gender;
		this.age = age;
		this.partyName = partyName;
	}
}
