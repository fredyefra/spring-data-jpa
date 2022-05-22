package br.com.spring.jpa.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import br.com.spring.jpa.dto.CustomerDTO;
import br.com.spring.jpa.dto.Mapper;
import br.com.spring.jpa.enums.AddressEnum;
import br.com.spring.jpa.enums.PhoneEnum;
import br.com.spring.jpa.model.Address;
import br.com.spring.jpa.model.Customer;
import br.com.spring.jpa.repository.CustomerRepository;
import br.com.spring.jpa.specification.CustomerSpecification;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository repository;

	/*
	 * public List<Customer> findAll(Long id, String lastName) {
	 * 
	 * return repository.findAll(Specification .where(CustomerSpecification.byId(id)
	 * .and(CustomerSpecification .byLastName(lastName)))); }
	 */

	
    public List<CustomerDTO> findAll() {
	
    	 return ((List<Customer>) repository  
                 .findAll())  
                 .stream()  
                 .map(this::convertDataIntoDTO)  
                         .collect(Collectors.toList());  
	    
	}
	
    
    private CustomerDTO convertDataIntoDTO (Customer customer) {  
        
          
    	CustomerDTO dto = new CustomerDTO();  
          
        dto.setFirstName(customer.getFirstName());  
        dto.setLastName(customer.getLastName());
        
        dto.setAddress(customer.getAddress());
        dto.getAddress().setCity(customer.getAddress().getCity());
        
        return dto;  
}  
    
    
    
	public List<Customer> customerByTypePhone(PhoneEnum phone) {

		return repository.findAll(Specification
	    		                  .where
	    		                  (CustomerSpecification.customerByTypePhone(phone)));
	    		                  
	    		                  
	}
	
	public List<Customer> getCustomerByTypeAddress(AddressEnum type) {
	    return repository.findAll(Specification
	    		                  .where(CustomerSpecification.customerByTypeAddress(type)));
	}
  
   public Customer findById(Long id) {
		Optional<Customer> optional = repository.findById(id);
		Customer customer = optional.get();
		return customer;
	}

	public Customer save(Customer customer) {
		customer.setId(null);
		return repository.save(customer);
	}

	public Customer update(Long id, Customer customer) {
		Customer object = findById(id); // if id exist jpa update object
		object.setFirstName(customer.getFirstName());
		object.setLastName(customer.getLastName());
		return repository.save(object);
	}

	public void delete(Long id) {
		Optional<Customer> optional = repository.findById(id);
		Customer customer = optional.get();
		repository.delete(customer);
	}
}