package com.cardService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cardService.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
