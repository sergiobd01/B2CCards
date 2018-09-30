package com.cardService.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.lang.Nullable;

@Entity
@Table(name= "CUSTOMER")
public class Customer {
	
	@Id
	@Column(name = "IDCUSTOMER")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCustomer;

	
	@Column(name = "IDCARD")
	private Long idCard;
	
	public Customer() {
	}

	public Customer(Long idCustomer, Long idCard) {
		this.idCustomer = idCustomer;
		this.idCard = idCard;
	}

	public Long getIdCustomer() {
		return idCustomer;
	}

	public void setIdCustomer(Long idCustomer) {
		this.idCustomer = idCustomer;
	}

	public long getIdCard() {
		return idCard;
	}

	public void setIdCard(Long idCard) {
		this.idCard = idCard;
	}
	
	

}
