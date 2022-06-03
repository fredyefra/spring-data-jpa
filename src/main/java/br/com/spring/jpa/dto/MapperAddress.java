package br.com.spring.jpa.dto;

import org.springframework.stereotype.Service;

import br.com.spring.jpa.enums.AddressEnum;
import br.com.spring.jpa.model.Customer;

@Service
public class MapperAddress {

	public AddressDTO convertAddressIntoDTO (Customer customer) {  
        
        Long id = customer.getId();
		String street = customer.getAddress().getStreet();  
        String city = customer.getAddress().getCity();  
        String zipCode = customer.getAddress().getZipCode();  
        AddressEnum type = customer.getAddress().getType();
          
        return new AddressDTO(id, street, city, zipCode, type);  
	}
}