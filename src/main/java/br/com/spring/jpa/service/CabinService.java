package br.com.spring.jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.spring.jpa.repository.CabinRepository;

@Service
public class CabinService {

	@Autowired
	private CabinRepository repository;
	
}
