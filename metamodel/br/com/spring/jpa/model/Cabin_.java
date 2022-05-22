package br.com.spring.jpa.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import br.com.spring.jpa.model.Cabin;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Cabin.class)
public abstract class Cabin_ {

	public static volatile SingularAttribute<Cabin, Long> id;
	public static volatile SingularAttribute<Cabin, Integer> deckLevel;
	public static volatile SingularAttribute<Cabin, String> cabinName;

	public static final String ID = "id";
	public static final String DECK_LEVEL = "deckLevel";
	public static final String CABIN_NAME = "cabinName";

}

