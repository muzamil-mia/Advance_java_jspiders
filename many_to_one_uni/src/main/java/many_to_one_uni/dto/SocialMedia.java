package many_to_one_uni.dto;

import javax.annotation.processing.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class SocialMedia {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id;
	private String platform;
	private String user;
	private String email;
	@ManyToOne
	private Person person;
}
