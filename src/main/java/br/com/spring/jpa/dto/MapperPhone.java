package br.com.spring.jpa.dto;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import br.com.spring.jpa.model.Customer;

@Service
public class MapperPhone {

	private ModelMapper modelMapper;
	
	public List<PhoneDTO> phonesToDTO (Customer customer) {
		
		this.modelMapper = new ModelMapper();
		
		List<PhoneDTO> dtos = customer
				  .getPhones()
				  .stream()
				  .map(phone -> this.modelMapper.map(phone, PhoneDTO.class))
				  .collect(Collectors.toList());
		
		return dtos;
	}
}