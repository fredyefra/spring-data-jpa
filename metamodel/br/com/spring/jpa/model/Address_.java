package br.com.spring.jpa.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import br.com.spring.jpa.enums.AddressEnum;
import br.com.spring.jpa.model.Address;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Address.class)
public abstract class Address_ {

	public static volatile SingularAttribute<Address, String> zipCode;
	public static volatile SingularAttribute<Address, String> city;
	public static volatile SingularAttribute<Address, String> street;
	public static volatile SingularAttribute<Address, Long> id;
	public static volatile SingularAttribute<Address, AddressEnum> type;

	public static final String ZIP_CODE = "zipCode";
	public static final String CITY = "city";
	public static final String STREET = "street";
	public static final String ID = "id";
	public static final String TYPE = "type";

}

