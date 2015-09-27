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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Agenda getAgenda() {
		return agenda;
	}

	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
	}

	public List<Member> getMembers() {
		return members;
	}

	public void setMembers(List<Member> members) {
		this.members = members;
	}

	public TypeDej getTypedej() {
		return typedej;
	}

	public void setTypedej(TypeDej typedej) {
		this.typedej = typedej;
	}

	public Double getPrix() {
		return prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getPrescence() {
		return prescence;
	}

	public void setPrescence(Boolean prescence) {
		this.prescence = prescence;
	}

	public String getFrequence() {
		return frequence;
	}

	public void setFrequence(String frequence) {
		this.frequence = frequence;
	}
	
	
	
	

}
