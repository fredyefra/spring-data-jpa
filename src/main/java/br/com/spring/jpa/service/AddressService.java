package br.com.spring.jpa.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.spring.jpa.model.Address;
import br.com.spring.jpa.repository.AddressRepository;
import br.com.spring.jpa.specification.AddressSpecification;

@Service
public class AddressService {

	@Autowired
	private AddressRepository repository;

	public List<Address> findAll() {
		return repository.findAll(AddressSpecification.byId(1L));
	}
	 
	
}
