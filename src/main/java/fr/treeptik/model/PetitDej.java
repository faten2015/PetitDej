package fr.treeptik.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;



@Entity(name = "petitdej")
public class PetitDej implements Serializable{
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Agenda agenda;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy="petitdej")
	List<Member>members;
	
	@Enumerated(EnumType.STRING)
	private TypeDej typedej;
	
	private Double prix;
	
	private Date date;
	
	private String description;
	
	private Boolean prescence;
	
	private String frequence;
	
	
	
	

}
