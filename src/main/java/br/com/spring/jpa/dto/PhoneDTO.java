package br.com.spring.jpa.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.spring.jpa.enums.PhoneEnum;

public class PhoneDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String number;
	private PhoneEnum type;
	
	public PhoneDTO() {
		
	}
	
	public PhoneDTO(Long id, String number, PhoneEnum type) {
		super();
		this.id = id;
		this.number = number;
		this.type = type;
	}

	@JsonIgnore
	public Long getId() {return id;}
	public void setId(Long id) {this.id = id;}
	
	//@JsonIgnore
	public String getNumber() {return number;}
	public void setNumber(String number) {this.number = number;}

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
		PhoneDTO other = (PhoneDTO) obj;
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