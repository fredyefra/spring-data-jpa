package br.com.spring.jpa.util;

import java.time.LocalDate;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.spring.jpa.enums.AddressEnum;
import br.com.spring.jpa.enums.FlagEnum;
import br.com.spring.jpa.enums.PhoneEnum;
import br.com.spring.jpa.model.Address;
import br.com.spring.jpa.model.CreditCard;
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
		
		Phone homeRobert = new Phone(null,"(21) 1111-1111" ,PhoneEnum.HOME);
		Phone cellRobert = new Phone(null,"(31) 2222-2222" ,PhoneEnum.CELL);
		Phone jobRobert = new Phone(null,"(51) 3333-3333" ,PhoneEnum.JOB);
		
		Phone homeJames = new Phone(null,"(61) 4444-4444" ,PhoneEnum.HOME);
		Phone jobJames = new Phone(null,"(11) 5555-5555" ,PhoneEnum.JOB);
		
		CreditCard eloCardRobert = new CreditCard(null,"65444-2222-1111-0000", FlagEnum.ELO, 300.0, LocalDate.now().plusYears(3));
		
		Customer c1 = new Customer();
		c1.setFirstName("Robert C. Martin");
		c1.setLastName("Martin");
		c1.setAddress(a1);
		c1.getPhones().addAll(List.of(homeRobert,cellRobert,jobRobert));
		c1.setCreditCard(eloCardRobert);
		
		CreditCard masterCardJames = new CreditCard(null,"5411-2299-3311-0000", FlagEnum.MASTERCARD, 500.0, LocalDate.now().plusYears(3));
		
		Customer c2 = new Customer();
		c2.setFirstName("James Gosling");
		c2.setLastName("Gosling");
		c2.setAddress(a2);
		c2.getPhones().addAll(List.of(homeJames,jobJames));
		c2.setCreditCard(masterCardJames);
		
		Collection<Customer> customers = new LinkedList<Customer>((List.of(c1,c2)));
		
		service.saveAll(customers);
	}
}