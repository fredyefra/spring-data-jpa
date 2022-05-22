package br.com.spring.jpa.specification;

import java.io.Serializable;

import org.springframework.data.jpa.domain.Specification;

import br.com.spring.jpa.enums.PhoneEnum;
import br.com.spring.jpa.model.Phone;
import br.com.spring.jpa.model.Phone_;

public class PhoneSpecification implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	* Lambda Specification
	*/
	public static Specification<Phone> byId(Long id) {
		return (root, query, builder) -> 
		  builder.equal(root.get(Phone_.id), id);
	}
	
	/**
	* Lambda Specification
	*/
	public static Specification<Phone> byNumber(String number) {
		return (root, query, builder) -> 
		  builder.equal(root.get(Phone_.number), number);
	}
	
	/**
	* Lambda Specification
	*/
	public static Specification<Phone> byType(PhoneEnum type) {
		return (root, query, builder) -> 
		  builder.equal(root.get(Phone_.type), type);
	}
}