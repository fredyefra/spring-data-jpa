package br.com.spring.jpa.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.spring.jpa.model.Phone;

public class CustomerDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String firstName;
	private String lastName;
	private AddressDTO address;
	private Collection<Phone> phones = new ArrayList<>();
	private Collection<PhoneDTO> phonesDTO = new ArrayList<>();
	
	public CustomerDTO() {

	}

	public CustomerDTO(Long id, String firstName, String lastName, AddressDTO address, Collection<Phone> phones) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phones = phones;
	}

	public CustomerDTO(String firstName, String lastName, AddressDTO address, Collection<PhoneDTO> phonesDTO) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phonesDTO = phonesDTO;
	}
	
	@JsonIgnore
	public Long getId() {return id;}
	public void setId(Long id) {this.id = id;}

	public String getFirstName() {return firstName; }
	public void setFirstName(String firstName) {this.firstName = firstName; }

	public String getLastName() {return lastName; }
	public void setLastName(String lastName) {this.lastName = lastName; }

	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	public AddressDTO getAddress() {return address;}
	public void setAddress(AddressDTO address) {this.address = address;}

	@JsonIgnore
	public Collection<Phone> getPhones() {return phones;}
	public void setPhones(Collection<Phone> phones) {this.phones = phones;}
	
	public Collection<PhoneDTO> getPhonesDTO() {return phonesDTO;}
	public void setPhonesDTO(Collection<PhoneDTO> phonesDTO) {this.phonesDTO = phonesDTO;}

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
		CustomerDTO other = (CustomerDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}