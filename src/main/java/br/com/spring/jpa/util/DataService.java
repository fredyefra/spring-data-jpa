package br.com.spring.jpa.util;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.spring.jpa.enums.AddressEnum;
import br.com.spring.jpa.enums.PhoneEnum;
import br.com.spring.jpa.model.Address;
import br.com.spring.jpa.model.Customer;
import br.com.spring.jpa.model.Phone;
import br.com.spring.jpa.repository.CustomerRepository;
import br.com.spring.jpa.service.CustomerService;

@Service
public class DataService {
	
	@Autowired
	private CustomerService service;

	@Autowired
	private CustomerRepository customerRepository;
	
	//@Transactional(propagation = Propagation.NESTED)
	public void startDB() {

		Address a1 = new Address(null, "Baker Street ", "Arizona", "1111-1111", AddressEnum.COMMERCIAL); 
		Address a2 = new Address(null, "7º Avennue ", "New York", "2222-2222",AddressEnum.RESIDENTIAL);
		
		Phone homeRobert = new Phone(null,"1111-1111" ,PhoneEnum.HOME);
		Phone cellRobert = new Phone(null,"2222-2222" ,PhoneEnum.CELL);
		Phone jobRobert = new Phone(null,"3333-3333" ,PhoneEnum.JOB);
		
		Phone homeJames = new Phone(null,"4444-4444" ,PhoneEnum.HOME);
		Phone jobJames = new Phone(null,"5555-5555" ,PhoneEnum.JOB);
		
		Customer c1 = new Customer();
		c1.setFirstName("Robert C. Martin");
		c1.setLastName("Martin");
		c1.setAddress(a1);
		c1.getPhones().addAll(List.of(homeRobert,cellRobert,jobRobert));
		
		Customer c2 = new Customer();
		c2.setFirstName("James Gosling");
		c2.setLastName("Gosling");
		c2.setAddress(a2);
		c2.getPhones().addAll(List.of(homeJames,jobJames));
		
		Collection<Customer> customers = new LinkedList<Customer>((List.of(c1,c2)));
		
		//service.saveAll(customers);
		 
		customerRepository.saveAll(customers);
	}
}