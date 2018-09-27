package com.cardService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//import org.springframework.data.jpa.repository.JpaRepository;

import com.cardService.model.CreditCard;

@Repository
public interface CardRepository extends JpaRepository<CreditCard, Long>  {
	

}
