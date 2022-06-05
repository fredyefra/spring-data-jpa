package br.com.spring.jpa.dto;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.spring.jpa.model.Address;
import br.com.spring.jpa.model.Customer;
import br.com.spring.jpa.model.Phone;

@Service
public class MapperCustomer {

	@Autowired
	private MapperAddress mapperAddress;

	// Lambda Expression
	public CustomerDTO convertCustomerIntoDTO(Customer customer) {  

		String firstName = customer.getFirstName();  
		String lastName = customer.getLastName();
		//Address address = customer.getAddress();
		AddressDTO addressDTO = mapperAddress.convertAddressIntoDTO(customer);

		List<Phone> phones = customer
				.getPhones()
				.stream()
				.map(temp -> {
					Phone phone = new Phone();
					phone.setId(temp.getId());
					phone.setNumber(temp.getNumber());
					phone.setType(temp.getType());

					return phone;
				}).collect(Collectors.toList());

		return new CustomerDTO(null, firstName, lastName, addressDTO, phones);  
	}

	// OLD
	public CustomerDTO convertDataIntoDTO (Customer customer) {  

		Long id = customer.getId();
		String firstName = customer.getFirstName();  
		String lastName = customer.getLastName();  
		//Address address = customer.getAddress();  
		AddressDTO addressDTO = mapperAddress.convertAddressIntoDTO(customer);
		Collection<Phone> phones = customer.getPhones();

		return new CustomerDTO(id, firstName, lastName, addressDTO, phones);  

	}
}