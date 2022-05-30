package br.com.spring.jpa.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.spring.jpa.enums.AddressEnum;
import br.com.spring.jpa.enums.PhoneEnum;
import br.com.spring.jpa.model.Address;
import br.com.spring.jpa.model.Customer;
import br.com.spring.jpa.model.Phone;
import br.com.spring.jpa.repository.CustomerRepository;
import br.com.spring.jpa.repository.PhoneRepository;
import br.com.spring.jpa.service.CustomerService;

@Service
public class DataService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private PhoneRepository phoneRepository;
	
	@Autowired
	private CustomerService service;
	
	@Transactional(propagation = Propagation.NESTED)
	public void startDB() {

		Address a1 = new Address(null, "Baker Street ", "Arizona", "1111-1111", AddressEnum.COMMERCIAL); 
		Address a2 = new Address(null, "7º Avennue ", "New York", "2222-2222",AddressEnum.RESIDENTIAL);
		Address a3 = new Address(null, "Robertsdale ", "Pensilvania", "3333-3333",AddressEnum.MESSAGE);
		Address a4 = new Address(null, "Green Sunday ", "California", "4444-4444",AddressEnum.COMMERCIAL);
		
		Phone home = new Phone(null,"1111-1111" ,PhoneEnum.HOME);
		Phone cell = new Phone(null,"2222-2222" ,PhoneEnum.CELL);
		Phone job = new Phone(null,"3333-3333" ,PhoneEnum.JOB);
		
		Phone homec2 = new Phone(null,"4444-4444" ,PhoneEnum.HOME);
		
		//Collection<Phone> phones1 = Arrays.asList(home, celular);
		
		Customer c1 = new Customer();
		c1.setFirstName("Robert C. Martin");
		c1.setLastName("Martin");
		c1.getPhones().addAll(List.of(home,cell,job));
		
		
		Customer c2 = new Customer();
		c2.setFirstName("Robert C. Martin 123");
		c2.setLastName("Martin 321");
		c2.getPhones().addAll(List.of(homec2));
		//c2.setPhones(phones1);
		
		
		Collection<Customer> clientes = Collections.synchronizedList(new ArrayList<>());
		
		clientes.addAll(List.of(c1,c2));
		
		
		service.saveAll(clientes);
		
		
		//customerRepository.saveAll(clientes);
		
		//Customer c3 = new Customer(null, "James Gosling", "Gosling",a3,   null);
		//Customer c4 = new Customer(null, "Erich Gamma", "Gamma",a4, null);		
		
		//addressRepository.saveAll(Arrays.asList(a1,a2,a3,a4)); @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
		//phoneRepository.saveAll(List.of(home));
		
		 
	}
}