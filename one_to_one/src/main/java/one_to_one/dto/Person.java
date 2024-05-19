package one_to_one.dto;
import javax.annotation.processing.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String email;
	private Long phone;
	private int age;
	@OneToOne(cascade = CascadeType.PERSIST)
	private PanCard panCard;
	
	public Person(String name, String email, Long phone, int age) {
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.age = age;
	}

	public Person(String name, String email, long phone, int age, PanCard panCard) {
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.age = age;
		this.panCard = panCard;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", age=" + age
				+ ", panCard=" + panCard + "]";
	}
}
