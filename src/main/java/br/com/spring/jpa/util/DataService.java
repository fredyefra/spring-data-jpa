package br.com.spring.jpa.util;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.spring.jpa.enums.AddressEnum;
import br.com.spring.jpa.enums.PhoneEnum;
import br.com.spring.jpa.model.Address;
import br.com.spring.jpa.model.Customer;
import br.com.spring.jpa.model.Phone;
import br.com.spring.jpa.repository.CustomerRepository;
import br.com.spring.jpa.repository.PhoneRepository;

@Service
public class DataService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private PhoneRepository phoneRepository;
	
	public void startDB() {

		Address a1 = new Address(null, "Baker Street ", "Arizona", "1111-1111", AddressEnum.COMMERCIAL); 
		Address a2 = new Address(null, "7º Avennue ", "New York", "2222-2222",AddressEnum.RESIDENTIAL);
		Address a3 = new Address(null, "Robertsdale ", "Pensilvania", "3333-3333",AddressEnum.MESSAGE);
		Address a4 = new Address(null, "Green Sunday ", "California", "4444-4444",AddressEnum.COMMERCIAL);
		
		Phone home = new Phone(null,"1111-1111" ,PhoneEnum.HOME);
		Phone celular = new Phone(null,"2222-2222" ,PhoneEnum.CELL);
		//Phone homePhone = new Phone(null,"1111-1111" ,PhoneEnum.JOB);
		
		Collection<Phone> phones1 = Arrays.asList(home);
		Collection<Phone> phones2 = Arrays.asList(celular);
		//List<Phone> phones3 = Arrays.asList(homePhone);
		
		Customer c1 = new Customer(null, "Robert C. Martin", "Martin",null, phones1);
		Customer c2 = new Customer(null, "Martin Fowler", "Fowler",null,    phones1);
		Customer c3 = new Customer(null, "James Gosling", "Gosling",a3,   phones1);
		Customer c4 = new Customer(null, "Erich Gamma", "Gamma",a4, phones1);		
		
		c1.setPhones(phones1);
		c2.setPhones(phones1);
		//addressRepository.saveAll(Arrays.asList(a1,a2,a3,a4)); @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
		
		customerRepository.saveAll(Arrays.asList(c1,c2));

	}
}