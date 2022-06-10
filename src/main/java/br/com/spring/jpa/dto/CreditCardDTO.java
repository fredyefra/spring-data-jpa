package br.com.spring.jpa.dto;

import java.io.Serializable;
import java.util.Date;

import br.com.spring.jpa.enums.FlagEnum;

public class CreditCardDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Date expirateDate;
	private  String number;
    private FlagEnum flagEnum;

    public CreditCardDTO() {
		
	}
	
    public CreditCardDTO(Long id, Date expirateDate, String number, FlagEnum flagEnum) {
		super();
		this.id = id;
		this.expirateDate = expirateDate;
		this.number = number;
		this.flagEnum = flagEnum;
	}
	
    public Long getId() {return id;}
	public void setId(Long id) {this.id = id;}
	
	public Date getExpirateDate() {return expirateDate;}
	public void setExpirateDate(Date expirateDate) {this.expirateDate = expirateDate;}
	
	public String getNumber() {return number;}
	public void setNumber(String number) {this.number = number;}
	
	public FlagEnum getFlagEnum() {return flagEnum;}
	public void setFlagEnum(FlagEnum flagEnum) {this.flagEnum = flagEnum;} 

    
    
}
