package br.com.spring.jpa.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.spring.jpa.enums.AddressEnum;

public class AddressDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String street;
	private String city;
	private String zipCode;
	private AddressEnum type;

	public AddressDTO() {
	}

	public AddressDTO(Long id, String street, String city, String zipCode, AddressEnum type) {
		super();
		this.id = id;
		this.street = street;
		this.city = city;
		this.zipCode = zipCode;
		this.type = type;
	}

	@JsonIgnore
	public Long getId() {return id;}
	public void setId(Long id) {this.id = id;}

	public String getStreet() {return street;}
	public void setStreet(String street) {this.street = street;}

	public String getCity() {return city;}
	public void setCity(String city) {this.city = city;}

	public String getZipCode() {return zipCode;}
	public void setZipCode(String zipCode) {this.zipCode = zipCode;}

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
		AddressDTO other = (AddressDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}