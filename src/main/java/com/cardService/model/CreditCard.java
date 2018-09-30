package com.cardService.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "CREDITCARD")
public class CreditCard {

	@Id
	@Column(name = "IDCARD")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idCard;
	
	@Column(name = "IDCUSTOMER")
	private long idCustomer;
	
	@Column(name = "NUMBERCARD")
	private String numberCard;

	@Column(name = "CARDTYPE")
	private String cardType;
	
	@Column(name = "EXPIRATIONMONTH")
	private int expirationMonth;
	
	@Column(name = "EXPIRATIONYEAR")
	private int expirationYear;
	
	public CreditCard() {
	
	}

	public CreditCard( long idCustomer, String numberCard, String cardType, int expirationMonth, int expirationYear) {
		//this.idCard = idCard;
		this.idCustomer = idCustomer;
		this.numberCard = numberCard;
		this.cardType = cardType;
		this.expirationMonth = expirationMonth;
		this.expirationYear = expirationYear;
	}

	public long getIdCard() {
		return idCard;
	}

	public void setIdCard(long idCard) {
		this.idCard = idCard;
	}

	public long getIdCustomer() {
		return idCustomer;
	}

	public void setIdCustomer(long idCustomer) {
		this.idCustomer = idCustomer;
	}

	public String getNumberCard() {
		return numberCard;
	}

	public void setNumberCard(String numberCard) {
		this.numberCard = numberCard;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public int getExpirationMonth() {
		return expirationMonth;
	}

	public void setExpirationMonth(int expirationMonth) {
		this.expirationMonth = expirationMonth;
	}

	public int getExpirationYear() {
		return expirationYear;
	}

	public void setExpirationYear(int expirationYear) {
		this.expirationYear = expirationYear;
	}

	
}
