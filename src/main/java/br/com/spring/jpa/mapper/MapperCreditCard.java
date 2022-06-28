package br.com.spring.jpa.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import br.com.spring.jpa.dto.CreditCardDTO;
import br.com.spring.jpa.dto.CustomerDTO;
import br.com.spring.jpa.enums.FlagEnum;
import br.com.spring.jpa.model.CreditCard;
import br.com.spring.jpa.model.Customer;

@Service
public class MapperCreditCard {

	private ModelMapper modelMapper;

	public MapperCreditCard() {
		this.modelMapper = new ModelMapper();
	}

	/**
	 * Entity to DTO - ModelMapper BoilerpLate OLD
	 * 
	 * @param {@link CreditCard}
	 * @return {@code CreditCard}
	 */
	public CreditCardDTO creditCardInDTO(Customer customer) {
		Long id = customer.getCreditCard().getId();
		String number = customer.getCreditCard().getNumber();
		FlagEnum flagEnum = customer.getCreditCard().getFlagEnum();
		return new CreditCardDTO(id, number, flagEnum);
	}

	/**
	 * Entity to DTO - ModelMapper
	 * 
	 * @param {@link CreditCard}}
	 * @return {@link CreditCardDTO}
	 */
	public CreditCardDTO creditCardToDTO(Customer customer) {

		CreditCardDTO creditCardDTO = modelMapper.map(customer.getCreditCard(), CreditCardDTO.class);

		return creditCardDTO;
	}

	/**
	 * DTO to Entity - ModelMapper
	 * 
	 * @param {@link CreditCardDTO}
	 * @return {@link CreditCard}
	 */
	public CreditCard dtoToCreditCard(CustomerDTO customerDTO) {

		CreditCard creditCard = modelMapper.map(customerDTO.getCreditCardDTO(), CreditCard.class);

		return creditCard;
	}
}