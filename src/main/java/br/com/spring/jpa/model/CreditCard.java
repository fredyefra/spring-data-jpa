package br.com.spring.jpa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.spring.jpa.enums.FlagEnum;

@Entity
public class CreditCard implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	//private Date expirateDate;
	private  String number;
    private FlagEnum flagEnum;
    private Long limit;
    
    public CreditCard() {
		
	}
	
    public CreditCard(Long id,String number, FlagEnum flagEnum) {
		super();
		this.id = id;
		this.number = number;
        this.flagEnum = flagEnum;
    }
	
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
    public Long getId() {return id;}
	public void setId(Long id) {this.id = id;}
	
	//@Column(name = "EXPIRATE_DATE")
	//public Date getExpirateDate() {return expirateDate;}
	//public void setExpirateDate(Date expirateDate) {this.expirateDate = expirateDate;}
	
	@Column(name = "NUMBER")
	public String getNumber() {return number;}
	public void setNumber(String number) {this.number = number;}
	
	@Enumerated(EnumType.STRING)
	@Column(name = "FLAG_ENUM")
	public FlagEnum getFlagEnum() {return flagEnum;}
	public void setFlagEnum(FlagEnum flagEnum) {this.flagEnum = flagEnum;} 

	//@Column(name = "LIMIT")
    //public Long getLimit() {return limit;}
    //public void setLimit(Long limit) {this.limit = limit;}
}