package one_to_many_uni.dto;

import javax.annotation.processing.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class SocialMedia {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id;
	private String sName;
	private String platform;
	private String userName;
	private String email;
	private String password;
	public SocialMedia(int id, String sName, String userName, String email, String password) {
		super();
		this.id = id;
		this.sName = sName;
		this.userName = userName;
		this.email = email;
		this.password = password;
	}
}
