package br.com.spring.jpa.mapper;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.spring.jpa.dto.AddressDTO;
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
	
	/** Implement Entity to DTO - BoilerpLate OLD 
	 */
	public CustomerDTO convertCustomerIntoDTO(Customer customer) {  

		String firstName = customer.getFirstName();  
		String lastName = customer.getLastName();

		AddressDTO addressDTO = mapperAddress.addressToDTO(customer);
		//List<PhoneDTO> phoneDTOs = mapperPhone.phonesToDTO(customer);
		
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

	/** Implement Entity to DTO - BoilerpLate OLD 
	 */
	public CustomerDTO convertDataIntoDTO (Customer customer) {  

		Long id = customer.getId();
		String firstName = customer.getFirstName();  
		String lastName = customer.getLastName();  
		AddressDTO addressDTO = mapperAddress.convertAddressInDTO(customer);
		Collection<PhoneDTO> phonesDTO = mapperPhone.phonesToDTO(customer);

        //return new CustomerDTO(id, firstName, lastName, addressDTO, phonesEntity);
		return new CustomerDTO(id, firstName, lastName, addressDTO, null);  

	}
}