package br.com.spring.jpa.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.spring.jpa.model.Address;
import br.com.spring.jpa.model.Phone;

public class CustomerDTO implements Serializable {

private static final long serialVersionUID = 1L;
	
	//private Long id;
    @JsonIgnore
    private String firstName;
	private String lastName;
    private Address address;
	private List<Phone> phones = new ArrayList<Phone>();
    
	public CustomerDTO() {
		
	}
	
	public CustomerDTO(String firstName, String lastName, Address address, List<Phone> phones) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	    this.address = address;
	    this.phones = phones;
	}
	
	public String getFirstName() {return firstName; }
	public void setFirstName(String firstName) {this.firstName = firstName; }
	
	public String getLastName() {return lastName; }
	public void setLastName(String lastName) {this.lastName = lastName; }
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	public Address getAddress() {return address;}
    public void setAddress(Address address) {this.address = address;}

    public List<Phone> getPhones() {return phones;}
	public void setPhones(List<Phone> phones) {this.phones = phones;}

	
	}