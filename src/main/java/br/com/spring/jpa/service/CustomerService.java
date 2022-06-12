package br.com.spring.jpa.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.spring.jpa.dto.CustomerDTO;
import br.com.spring.jpa.enums.AddressEnum;
import br.com.spring.jpa.enums.PhoneEnum;
import br.com.spring.jpa.mapper.MapperCustomer;
import br.com.spring.jpa.model.Customer;
import br.com.spring.jpa.repository.CustomerRepository;
import br.com.spring.jpa.specification.CustomerSpecification;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository repository;

	@Autowired
	private MapperCustomer mapper;
	
	public Collection<CustomerDTO> findAll() {
    	 return ((List<CustomerDTO>) repository
    			 .findAll()  
    			 .stream()  
                 .map(mapper::customerToDTO)  
                         .collect(Collectors.toList()));    
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

	@Transactional
	public List<Customer> saveAll(Collection<Customer> entities) {

		List<Customer> result = new ArrayList<Customer>();

		for (Customer entity : entities) {
			result.add(save(entity));
		}

		return result;
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