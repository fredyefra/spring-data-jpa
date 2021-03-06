package br.com.spring.jpa.controller;

import java.net.URI;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.spring.jpa.dto.CustomerDTO;
import br.com.spring.jpa.model.Customer;
import br.com.spring.jpa.service.CustomerService;
import io.swagger.annotations.Api;

//@CrossOrigin("*")
@Api(value = "customer")
@RestController
@CrossOrigin("http://localhost:8080")
@RequestMapping(value = "/customers")
public class CustomerResource {

	@Autowired
	private CustomerService service;

	//@ApiOperation(value = "{Find All Customers, phones and address}")
	@GetMapping
	public ResponseEntity<Collection<CustomerDTO>> findAll() {
    Collection<CustomerDTO> customers = service.findAll();
		return ResponseEntity.ok(customers);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Customer> findById(@PathVariable Long id) {
		Customer customer = service.findById(id);
		return ResponseEntity.ok().body(customer);
	}

	@PostMapping
	public ResponseEntity<Customer> save(@RequestBody Customer customer) {
		Customer response = service.save(customer);
		return ResponseEntity.created(URI.create("/customer/" + response.getId())).build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Customer> update(@PathVariable Long id, @RequestBody Customer customer){
		Customer object = service.update(id, customer);
		return ResponseEntity.ok().body((object));
	}

	@DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		//return ResponseEntity.ok().body(null);
		return ResponseEntity.noContent().build();
	}
}