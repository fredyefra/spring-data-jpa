package br.com.spring.jpa.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import br.com.spring.jpa.dto.AddressDTO;
import br.com.spring.jpa.dto.CustomerDTO;
import br.com.spring.jpa.enums.AddressEnum;
import br.com.spring.jpa.model.Address;
import br.com.spring.jpa.model.Customer;

@Service
public class MapperAddress {

	private ModelMapper modelMapper;

	public MapperAddress() {
		this.modelMapper = new ModelMapper();
	}

	/**
	 * Entity to DTO - ModelMapper BoilerpLate OLD
	 * 
	 * @param {@link Customer}
	 * @return {@code AddressDTO}
	 */
	public AddressDTO addressInDTO(Customer customer) {
		Long id = customer.getId();
		String street = customer.getAddress().getStreet();
		String city = customer.getAddress().getCity();
		String zipCode = customer.getAddress().getZipCode();
		AddressEnum type = customer.getAddress().getType();

		return new AddressDTO(id, street, city, zipCode, type);
	}

	/**
	 * Entity to DTO - ModelMapper
	 * 
	 * @param {@link Customer}}
	 * @return {@link AddressDTO}
	 */
	public AddressDTO addressToDTO(Customer customer) {

		AddressDTO addressDTO = modelMapper.map(customer.getAddress(), AddressDTO.class);

		return addressDTO;
	}

	/**
	 * DTO to Entity - ModelMapper
	 * 
	 * @param {@link CustomerDTO}
	 * @return {@link Address}
	 */
	public Address dtoToAddress(CustomerDTO customerDTO) {

		Address address = modelMapper.map(customerDTO.getAddress(), Address.class);

		return address;
	}
}