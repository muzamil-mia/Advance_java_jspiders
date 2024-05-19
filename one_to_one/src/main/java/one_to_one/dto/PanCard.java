package one_to_one.dto;
import java.sql.Date;

import javax.annotation.processing.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class PanCard {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String panNumber;
	private String fatherName;
	private String paName;
	private String dob;
	
	@Override
	public String toString() {
		return "PanCard [id=" + id + ", panNumber=" + panNumber + ", fatherName=" + fatherName + ", paName=" + paName
				+ ", dob=" + dob + "]";
	}

	public PanCard(String panNumber, String fatherName, String panName, Date dOB) {
		super();
		this.id = id;
		this.panNumber = panNumber;
		this.fatherName = fatherName;
		this.paName = paName;
		this.dob = dob;
	}
	
}
