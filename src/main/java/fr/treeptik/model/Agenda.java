package fr.treeptik.model;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity(name = "agenda")
public class Agenda implements Serializable{

private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Integer id;
	
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy="agenda")
	private List<PetitDej> petitdejs;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public List<PetitDej> getPetitdejs() {
		return petitdejs;
	}


	public void setPetitdejs(List<PetitDej> petitdejs) {
		this.petitdejs = petitdejs;
	}



	
	
	

	
	
	
	
}
