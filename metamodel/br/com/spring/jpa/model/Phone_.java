package br.com.spring.jpa.model;

import br.com.spring.jpa.enums.PhoneEnum;
import br.com.spring.jpa.model.Phone;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Phone.class)
public abstract class Phone_ {

	public static volatile SingularAttribute<Phone, String> number;
	public static volatile SingularAttribute<Phone, Long> id;
	public static volatile SingularAttribute<Phone, PhoneEnum> type;

	public static final String NUMBER = "number";
	public static final String ID = "id";
	public static final String TYPE = "type";

}

