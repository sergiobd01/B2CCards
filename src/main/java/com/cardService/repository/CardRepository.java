package com.cardService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//import org.springframework.data.jpa.repository.JpaRepository;

import com.cardService.model.CreditCard;

@Repository
public interface CardRepository extends JpaRepository<CreditCard, Long>  {
	
	public List<CreditCard> findByidCustomer(Long idCustomer);

}
