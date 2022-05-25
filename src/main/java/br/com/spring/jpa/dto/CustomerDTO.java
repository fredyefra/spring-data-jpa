package br.com.spring.jpa.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.spring.jpa.model.Address;
import br.com.spring.jpa.model.Phone;

public class CustomerDTO implements Serializable {

private static final long serialVersionUID = 1L;
	
    //@JsonIgnore
	private Long id;
    private String firstName;
	private String lastName;
    private Address address;
	private Collection<Phone> phones = new ArrayList<Phone>();
    
	public CustomerDTO() {
		
	}
	
	public CustomerDTO(Long id, String firstName, String lastName, Address address, Collection<Phone> phones) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	    this.address = address;
	    this.phones = phones;
	}
	
	public Long getId() {return id;}
	public void setId(Long id) {this.id = id;}
	
	public String getFirstName() {return firstName; }
	public void setFirstName(String firstName) {this.firstName = firstName; }
	
	public String getLastName() {return lastName; }
	public void setLastName(String lastName) {this.lastName = lastName; }
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	public Address getAddress() {return address;}
    public void setAddress(Address address) {this.address = address;}

    public Collection<Phone> getPhones() {return phones;}
	public void setPhones(Collection<Phone> phones) {this.phones = phones;}

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