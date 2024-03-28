package dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class StudentDTO {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	private String name;
	private String email;
	private String password;
	private double marks;
	public StudentDTO() {
		super();
	}
	public StudentDTO(String name, String email, String password, double marks) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.marks=marks;
	}
}
