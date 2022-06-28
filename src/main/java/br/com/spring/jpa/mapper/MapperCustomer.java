package br.com.spring.jpa.mapper;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.spring.jpa.dto.AddressDTO;
import br.com.spring.jpa.dto.CreditCardDTO;
import br.com.spring.jpa.dto.CustomerDTO;
import br.com.spring.jpa.dto.PhoneDTO;
import br.com.spring.jpa.model.Customer;
import br.com.spring.jpa.model.Phone;

@Service
public class MapperCustomer {

	@Autowired
	private MapperAddress mapperAddress;

	@Autowired
	private MapperPhone mapperPhone;

	@Autowired
	private MapperCreditCard mapperCreditCard;
	
	/**
	 * Entity to DTO - ModelMapper BoilerpLate OLD - NOT ERASE IN REFACTORY
	 * 
	 * @param {@link Customer}
	 * @return {@code List Phone}
	 */
	public CustomerDTO customerInDTO(Customer customer) {  

		String firstName = customer.getFirstName();  
		String lastName = customer.getLastName();

		AddressDTO addressDTO = mapperAddress.addressToDTO(customer);
		
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

	/**
	 * Entity to DTO - ModelMapper BoilerpLate OLD - NOT ERASE IN REFACTORY
	 * 
	 * @param {@link Customer}
	 * @return {@code CustomerDTO}
	 */
	public CustomerDTO convertDataIntoDTO (Customer customer) {  
		
		Long id = customer.getId();
		String firstName = customer.getFirstName();  
		String lastName = customer.getLastName();  
		AddressDTO addressDTO = mapperAddress.addressInDTO(customer);
		Collection<PhoneDTO> phonesDTO = mapperPhone.phonesToDTO(customer);
		
		//return new CustomerDTO(id, firstName, lastName, addressDTO, phonesEntity);
		return new CustomerDTO(id, firstName, lastName, addressDTO, null);  
		
	}
	
	/** 
	 * Entity to DTO - ModelMapper
	 * 
	 * @param {@link Customer}  
	 * @return {@link CustomerDTO}
	 */
	public CustomerDTO customerToDTO(Customer customer) {  

		String firstName = customer.getFirstName();  
		String lastName = customer.getLastName();

		AddressDTO addressDTO = mapperAddress.addressToDTO(customer);
		List<PhoneDTO> phoneDTOs = mapperPhone.phonesToDTO(customer);
		CreditCardDTO creditCardDTO = mapperCreditCard.creditCardToDTO(customer);
		
		return new CustomerDTO(firstName, lastName, addressDTO, phoneDTOs, creditCardDTO);
	}
}