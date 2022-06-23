package br.com.spring.jpa.model;

import br.com.spring.jpa.enums.FlagEnum;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CreditCard.class)
public abstract class CreditCard_ {

	public static volatile SingularAttribute<CreditCard, String> number;
	public static volatile SingularAttribute<CreditCard, FlagEnum> flagEnum;
	public static volatile SingularAttribute<CreditCard, Long> limit;
	public static volatile SingularAttribute<CreditCard, Long> id;
	public static volatile SingularAttribute<CreditCard, Date> expirateDate;

	public static final String NUMBER = "number";
	public static final String FLAG_ENUM = "flagEnum";
	public static final String LIMIT = "limit";
	public static final String ID = "id";
	public static final String EXPIRATE_DATE = "expirateDate";

}

