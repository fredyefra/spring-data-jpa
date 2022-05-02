package br.com.spring.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.spring.jpa.entity.Customer;
import br.com.spring.jpa.service.CustomerService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/customers")
public class CustomerResource {

	@Autowired
	private CustomerService service;
	
	//@GetMapping(value = "/")
	//public List<Customer> findAll() {
		//return service.findAll();
	//}

	@GetMapping(value = "/")
	public ResponseEntity<List<Customer>> findAllCustomers() {
		List<Customer> customers = service.findAll();
		return ResponseEntity.ok(customers);
	}
	
	
}
