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
	
	/**Implement Entity to DTO - ModelMapper
	 * @param {@link Customer}}  
	 * @return {@link PhoneDTO}
	 */
	public List<PhoneDTO> phonesToDTO (Customer customer) {
		
		//this.modelMapper = new ModelMapper();
		
		List<PhoneDTO> dtos = customer
				  .getPhones()
				  .stream()
				  .map(phone -> this.modelMapper.map(phone, PhoneDTO.class))
				  .collect(Collectors.toList());
		
		return dtos;
	}

    public List<Phone> DTOtoPhone(CustomerDTO customerDTO) {
		
    	//this.modelMapper = new ModelMapper();
    	
    	//List<Phone> phones = customerDTO.get
    	
    	return null;
	}
  }