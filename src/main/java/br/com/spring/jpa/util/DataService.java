package br.com.spring.jpa.util;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.spring.jpa.enums.AddressEnum;
import br.com.spring.jpa.enums.PhoneEnum;
import br.com.spring.jpa.model.Address;
import br.com.spring.jpa.model.Customer;
import br.com.spring.jpa.model.Phone;
import br.com.spring.jpa.repository.AddressRepository;
import br.com.spring.jpa.repository.CustomerRepository;

@Service
public class DataService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	public void startDB() {

		Address a1 = new Address(null, "Baker Street ", "Arizona", "1111-1111", AddressEnum.COMMERCIAL); 
		Address a2 = new Address(null, "7º Avennue ", "New York", "2222-2222",AddressEnum.RESIDENTIAL);
		Address a3 = new Address(null, "Robertsdale ", "Pensilvania", "3333-3333",AddressEnum.MESSAGE);
		Address a4 = new Address(null, "Green Sunday ", "California", "4444-4444",AddressEnum.COMMERCIAL);
		
		Phone celular = new Phone(null,"1111-1111" ,PhoneEnum.CELL);
		Phone home = new Phone(null,"1111-1111" ,PhoneEnum.HOME);
		Phone homePhone = new Phone(null,"1111-1111" ,PhoneEnum.JOB);
		
		Phone p4 = new Phone(null,"1111-1111" ,PhoneEnum.CELL);
		Phone p5 = new Phone(null,"1111-1111" ,PhoneEnum.HOME);
		
		Phone p6 = new Phone(null,"1111-1111" ,PhoneEnum.JOB);
		
		List<Phone> phones1 = Arrays.asList(celular,home,homePhone);
		List<Phone> phones2 = Arrays.asList(celular,home);
		List<Phone> phones3 = Arrays.asList(homePhone);
		
		Customer c1 = new Customer(null, "Robert C. Martin", "Martin",a1, phones1);
		Customer c2 = new Customer(null, "Martin Fowler", "Fowler",a2,    phones2);
		Customer c3 = new Customer(null, "James Gosling", "Gosling",a3,   null);
		Customer c4 = new Customer(null, "Erich Gamma", "Gamma",a4, phones3);		
		
		//addressRepository.saveAll(Arrays.asList(a1,a2,a3,a4)); @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
		customerRepository.saveAll(Arrays.asList(c1, c2, c3,c4));

	}
}