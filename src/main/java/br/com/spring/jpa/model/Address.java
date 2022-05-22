package br.com.spring.jpa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.spring.jpa.enums.AddressEnum;

@Entity
public class Address implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String street;
	private String city;
	private String zipCode;
    private AddressEnum type;
	
	public Address() {
	}
	
	public Address(Long id, String street, String city, String zipCode, AddressEnum type) {
		super();
		this.id = id;
		this.street = street;
		this.city = city;
		this.zipCode = zipCode;
	    this.type = type;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public Long getId() {return id;}
	public void setId(Long id) {this.id = id;}
	
	@Column(name = "street")
	public String getStreet() {return street;}
	public void setStreet(String street) {this.street = street;}
	
	@Column(name = "city")
	public String getCity() {return city;}
	public void setCity(String city) {this.city = city;}
	
	@Column(name = "zipCode")
	public String getZipCode() {return zipCode;}
	public void setZipCode(String zipCode) {this.zipCode = zipCode;}
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "type")
	public AddressEnum getType() {return type;}
    public void setType(AddressEnum type) {this.type = type;}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}