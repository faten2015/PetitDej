package fr.treeptik.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;



@Entity(name = "responsable")
@DiscriminatorValue("Responsable")
public class Responsable extends Member implements Serializable{
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Integer id;

	@OneToOne
	private Team team;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	
	
}
