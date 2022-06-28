package br.com.spring.jpa.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.spring.jpa.enums.FlagEnum;

public class CreditCardDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	//private Date expirateDate;
	private  String number;
    private FlagEnum flagEnum;
    //private Long limit;
    
    public CreditCardDTO() {

    }
	
    public CreditCardDTO(Long id,String number,FlagEnum flagEnum) {
		super();
		this.id = id;
		this.number = number;
        this.flagEnum = flagEnum;
    }
	
    @JsonIgnore
    public Long getId() {return id;}
	public void setId(Long id) {this.id = id;}
	
	public String getNumber() {return number;}
	public void setNumber(String number) {this.number = number;}

	public FlagEnum getFlagEnum() {return flagEnum;}
	public void setFlagEnum(FlagEnum flagEnum) {this.flagEnum = flagEnum;}
	
}