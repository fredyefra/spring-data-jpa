package br.com.spring.jpa.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import br.com.spring.jpa.dto.CustomerDTO;
import br.com.spring.jpa.dto.PhoneDTO;
import br.com.spring.jpa.model.Customer;
import br.com.spring.jpa.model.Phone;

@Service
public class MapperPhone {

	private ModelMapper modelMapper;

	public MapperPhone() {
		this.modelMapper = new ModelMapper();
	}

	/**
	 * Entity to DTO - ModelMapper
	 * 
	 * @param {@link Customer}
	 * @return {@code List PhoneDTO}
	 */
	public List<PhoneDTO> phonesToDTO(Customer customer) {

		List<PhoneDTO> dtos = customer
				.getPhones()
				.stream()
				.map(phone -> this.modelMapper.map(phone, PhoneDTO.class))
				.collect(Collectors.toList());

		return dtos;
	}

	/**
	 * DTO to Entity - ModelMapper
	 * 
	 * @param {@link CustomerDTO}
	 * @return {@link List Phone}
	 */
	public List<Phone> DTOtoPhones(CustomerDTO customerDTO) {

		List<Phone> phones = customerDTO
				.getPhonesDTO()
				.stream()
				.map(dto -> this.modelMapper.map(dto, Phone.class))
				.collect(Collectors.toList());

		return phones;
	}
}