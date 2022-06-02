package br.com.spring.jpa.specification;

import java.io.Serializable;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import br.com.spring.jpa.enums.AddressEnum;
import br.com.spring.jpa.enums.PhoneEnum;
import br.com.spring.jpa.model.Address;
import br.com.spring.jpa.model.Address_;
import br.com.spring.jpa.model.Customer;
import br.com.spring.jpa.model.Customer_;
import br.com.spring.jpa.model.Phone;
import br.com.spring.jpa.model.Phone_;

public class CustomerSpecification implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	* Lambda Specification
	*/
	public static Specification<Customer> byFirstName(String firstName) {
		return (root, query, builder) -> 
		  builder.like(root.get(Customer_.firstName), firstName);
	}
	  
	/**
	 * Lambda Specification 
	 */
	public static Specification<Customer> byLastName(String lastName) {
		return (root, query, builder) -> 
		  builder.like(root.get(Customer_.lastName), lastName);
	}
	
	/**
	 * Lambda Specification 
	 */
	public static Specification<Customer> customerByTypeAddress(AddressEnum type) {
		return (root, query, builder) -> {
			
			Join<Customer, Address> addressJoin = root.join(Customer_.address);
			
			Predicate predicate = builder.equal(addressJoin.get(Address_.type), type);
			
			query
			    .where(predicate);
			
			return predicate;

		};
	} 

	/**
	 * Lambda Specification 
	 */
	public static Specification<Customer> allCustomersByIdPhone() {
	    return (root, query, criteriaBuilder) -> {
	        Join<Customer, Phone> phoneJoin = root.join(Customer_.phones, JoinType.INNER);
	        return criteriaBuilder.equal(phoneJoin.get(Phone_.id), 1L);
	    };
	} 
	
	/**
	 * Lambda Specification 
	 */
	public static Specification<Customer> customerByTypePhone(PhoneEnum typePhone){ 
		return (root, query, builder) -> {
			
		Join<Customer, Phone> phoneJoin = root.join(Customer_.phones, JoinType.INNER);
	    
		Predicate predicate = builder.and(
	    		builder.equal(phoneJoin.get(Phone_.type),typePhone)
	    		 ,builder.equal(root.get(Customer_.id), null));
	    
	    query
			.where(predicate);
			
		return predicate;	
			 
		};
	} 
	
	/**
	 * Lambda Specification 
	 */
	public static Specification<Customer> customerByAddress(AddressEnum typeAddress){ 
		return (root, query, builder) -> {
			
		Join<Customer, Address> addressJoin = root.join(Customer_.address);
			
	    Predicate predicate = builder.equal(addressJoin.get(Address_.type),typeAddress); 
		
		query
			.where(builder
					.equal(addressJoin
							.get(Address_.type), typeAddress));
			
		return builder.and(predicate);	
			 
		};
	}
	
	
	/**
	 * Common Specification
	 */
	public static Specification<Customer> test(Long id) {
		return new Specification<Customer>() {
			@Override
			public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				
			query  = cb.createQuery(Customer.class);
			root   = query.from(Customer.class);	
			query.multiselect(root);
			return cb.equal(root.get(Customer_.id), id); // NAO APAGAR
			}
		};

	}
}