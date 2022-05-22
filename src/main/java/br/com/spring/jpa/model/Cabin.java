package br.com.spring.jpa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cabin implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Integer deckLevel;
    private String cabinName;
	
    public Cabin() {
		
	}
    
    public Cabin(Long id, Integer deckLevel, String cabinName) {
		this.id = id;
		this.deckLevel = deckLevel;
		this.cabinName = cabinName;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public Long getId() {return id;}
    public void setId(Long id) { this.id = id;}

    @Column(name = "deckLevel")
	public Integer getDeckLevel() {return deckLevel;}
	public void setDeckLevel(Integer deckLevel) {this.deckLevel = deckLevel;}

	@Column(name = "cabinName")
	public String getCabinName() {return cabinName;}
	public void setCabinName(String cabinName) {this.cabinName = cabinName;}
 
}