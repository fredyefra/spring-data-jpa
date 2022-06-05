package br.com.spring.jpa.dto;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import br.com.spring.jpa.enums.AddressEnum;
import br.com.spring.jpa.model.Customer;

@Service
public class MapperAddress {

	/** Implement Entity to DTO - BoilerpLate OLD 
	 */
	public AddressDTO convertAddressIntoDTO (Customer customer) {  

		Long id = customer.getId();
		String street = customer.getAddress().getStreet();  
		String city = customer.getAddress().getCity();  
		String zipCode = customer.getAddress().getZipCode();  
		AddressEnum type = customer.getAddress().getType();

		return new AddressDTO(id, street, city, zipCode, type);  
	}

	/** Implement Entity to DTO - ModelMapper 
	 */	
	public AddressDTO addressToDTO(Customer customer) {

		ModelMapper modelMapper = new ModelMapper();

		AddressDTO addressDTO = modelMapper.map(customer.getAddress(), AddressDTO.class);

		return addressDTO;
	}
}