package br.com.spring.jpa.util;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.spring.jpa.entity.Customer;
import br.com.spring.jpa.repository.CustomerRepository;

@Service
public class DataService {

	@Autowired
	private CustomerRepository customerRepository;
	
	public void startDB() {

		Customer c1 = new Customer(null, "Robert C. Martin", "Martin");
		Customer c2 = new Customer(null, "Martin Fowler", "Fowler");
		Customer c3 = new Customer(null, "James Gosling", "Gosling");
				
		customerRepository.saveAll(Arrays.asList(c1, c2, c3));

	}
}