package br.com.spring.jpa.specification;

import java.io.Serializable;

import org.springframework.data.jpa.domain.Specification;

import br.com.spring.jpa.model.Address;
import br.com.spring.jpa.model.Address_;

public class AddressSpecification implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	* Lambda Specification
	*/
	public static Specification<Address> byId(Long id) {
		return (root, query, builder) -> 
		  builder.equal(root.get(Address_.id), id);
	}
	
}
