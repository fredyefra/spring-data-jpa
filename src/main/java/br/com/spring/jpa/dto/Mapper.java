 package br.com.spring.jpa.dto;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import br.com.spring.jpa.model.Customer;

@Service
public class Mapper {

	@Bean
	public org.modelmapper.ModelMapper modelMapper() {
		return new org.modelmapper.ModelMapper();
	}

	//@Bean
	public Customer converteParaEntidade(CustomerDTO dto) {
		Customer customer = modelMapper().map(dto, Customer.class);
		return customer;
	}
}