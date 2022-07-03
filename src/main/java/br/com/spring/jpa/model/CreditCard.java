package br.com.spring.jpa.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.spring.jpa.enums.FlagEnum;

@Entity
public class CreditCard implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private  String number;
    private FlagEnum flagEnum;
    private Double limit;
    private LocalDate expirateDate;
    
    public CreditCard() {
		
	}
	
    public CreditCard(Long id,String number, FlagEnum flagEnum, Double limit, LocalDate expirateDate) {
		super();
		this.id = id;
		this.number = number;
        this.flagEnum = flagEnum;
        this.limit = limit;
        this.expirateDate = expirateDate;
    }
	
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
    public Long getId() {return id;}
	public void setId(Long id) {this.id = id;}
	
	@Column(name = "CARD_NUMBER")
	public String getNumber() {return number;}
	public void setNumber(String number) {this.number = number;}
	
	@Enumerated(EnumType.STRING)
	@Column(name = "FLAG_ENUM")
	public FlagEnum getFlagEnum() {return flagEnum;}
	public void setFlagEnum(FlagEnum flagEnum) {this.flagEnum = flagEnum;} 

	@Column(name = "CARD_LIMIT")
    //@NumberFormat(pattern = "#,##.00", style = Style.NUMBER)
	public Double getLimit() {return limit;}
    public void setLimit(Double limit) {this.limit = limit;}

    @Column(name = "CARD_EXPIRATE_DATE")
    @JsonFormat(pattern="yyyy-MM-dd")
    public LocalDate getExpirateDate() {return expirateDate;}
    public void setExpirateDate(LocalDate expirateDate) {this.expirateDate = expirateDate;}
}