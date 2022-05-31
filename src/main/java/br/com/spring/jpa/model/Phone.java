package br.com.spring.jpa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.spring.jpa.enums.PhoneEnum;

@Entity
public class Phone implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String number;
	private PhoneEnum type;
	
	
	public Phone() {
		
	}
	
	public Phone(Long id, String number, PhoneEnum type) {
		super();
		this.id = id;
		this.number = number;
		this.type = type;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public Long getId() {return id;}
	public void setId(Long id) {this.id = id;}
	
	@Column(name = "number")
	public String getNumber() {return number;}
	public void setNumber(String number) {this.number = number;}

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "type")
	public PhoneEnum getType() {return type;}
	public void setType(PhoneEnum type) {this.type = type;}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Phone other = (Phone) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		if (type != other.type)
			return false;
		return true;
	}
	
}