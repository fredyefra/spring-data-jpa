package br.com.spring.jpa.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.spring.jpa.model.Customer;
import br.com.spring.jpa.model.Phone;
import br.com.spring.jpa.repository.PhoneRepository;

@Service
public class PhoneService {

	@Autowired
	private PhoneRepository repository;

	public Phone save(Phone phone) {
		if (phone.getId() == null) {
			repository.save(phone);
		}
		return phone; 
	}

	//@Transactional
	public List<Phone> saveAll(Collection<Phone> entities) {

		List<Phone> result = new ArrayList<Phone>();

		for (Phone entity : entities) {
			result.add(save(entity));
		}

		return result;
	}
	
	
	/*
	 * public Phone update(Long id, Phone hhone) { Customer object = findById(id);
	 * // if id exist jpa update object
	 * object.setFirstName(customer.getFirstName());
	 * object.setLastName(customer.getLastName()); return repository.save(object); }
	 */


}
