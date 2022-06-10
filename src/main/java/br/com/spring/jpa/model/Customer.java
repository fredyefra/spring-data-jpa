package br.com.spring.jpa.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Customer implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String firstName;
	private String lastName;
	private Address address;
	private Collection<Phone> phones = new ArrayList<Phone>();

	public Customer() {

	}

	public Customer(Long id, String firstName, String lastName, Address address, Collection<Phone> phones) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phones = phones;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	public Long getId() {return id; }
	public void setId(Long id) {this.id = id; }

	@Column(name = "FIRST_NAME")
	public String getFirstName() {return firstName; }
	public void setFirstName(String firstName) {this.firstName = firstName; }

	@Column(name = "LAST_NAME")
	public String getLastName() {return lastName; }
	public void setLastName(String lastName) {this.lastName = lastName; }

	@OneToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER) // Refactory remove CASCADE DATASERVICE remove, fetchType.LAZY
	@JoinColumn(name = "ADDRESS_FK")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	public Address getAddress() {return address;}
	public void setAddress(Address address) {this.address = address;}

	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER, orphanRemoval = true)
	@JoinTable(
			name="CUSTOMER_PHONE",
			joinColumns=
			@JoinColumn(name="CUSTOMER_FK", referencedColumnName="ID"),
			inverseJoinColumns=
			@JoinColumn(name="PHONE_FK", referencedColumnName="ID")
			)
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
		Customer other = (Customer) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}