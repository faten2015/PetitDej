package fr.treeptik.model;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;



@Entity(name = "note")
public class Note implements Serializable{
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Integer id;
	
	
	@OneToOne
	private PetitDej petitdej;
	
	@OneToOne 
	private Member member;
	
	private Double note;
	
	private String commentaires;
	
	
	

}
