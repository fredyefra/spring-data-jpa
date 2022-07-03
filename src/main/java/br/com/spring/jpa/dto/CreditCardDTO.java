package br.com.spring.jpa.dto;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.spring.jpa.enums.FlagEnum;

public class CreditCardDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private  String number;
    private FlagEnum flagEnum;
    private Double limit;
    private LocalDate expirateDate;
    
    public CreditCardDTO() {

    }
	
    public CreditCardDTO(Long id, String number, FlagEnum flagEnum, Double limit, LocalDate expirateDate) {
		super();
		this.id = id;
		this.number = number;
        this.flagEnum = flagEnum;
        this.limit = limit;
        this.expirateDate = expirateDate;
    }
	
    @JsonIgnore
    public Long getId() {return id;}
	public void setId(Long id) {this.id = id;}
	
	public String getNumber() {return number;}
	public void setNumber(String number) {this.number = number;}

	public FlagEnum getFlagEnum() {return flagEnum;}
	public void setFlagEnum(FlagEnum flagEnum) {this.flagEnum = flagEnum;}
	
	//@NumberFormat(pattern = "#,##.00", style = Style.NUMBER)
	public Double getLimit() {	return limit;}
	public void setLimit(Double limit) {this.limit = limit;}
   
	@JsonFormat(pattern="yyyy-MM-dd")
	public LocalDate getExpirateDate() {return expirateDate;}
    public void setExpirateDate(LocalDate expirateDate) {this.expirateDate = expirateDate;}

}