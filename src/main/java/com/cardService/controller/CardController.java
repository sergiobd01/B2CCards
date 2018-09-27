package com.cardService.controller;

import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cardService.model.CreditCard;
import com.cardService.model.Customer;
import com.cardService.payload.CardRequest;
import com.cardService.payload.CardResponse;
import com.cardService.repository.CustomerRepository;
import com.cardService.repository.CardRepository;


@RestController
@CrossOrigin(origins = "*")
public class CardController {
		
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	CardRepository cardRepository;

    @RequestMapping(
  	      value = "/registeCard",
  	      method = RequestMethod.POST,
  	      produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CardResponse> registerOrder(@RequestBody CardRequest cardRequest) {

    	CreditCard card = new CreditCard(1L, cardRequest.getIdCustomer(), cardRequest.getNumberCard(), cardRequest.getCardType(), cardRequest.getExpirationMonth(), cardRequest.getExpirationYear());
    	         
    	CreditCard cardResult = new CreditCard();
    	CardResponse cardResponse = new CardResponse("", false);
    	
        if(customerRepository.existsById(card.getIdCustomer()))
        {
        	cardResult =  cardRepository.save(card);
        	Customer customer = new Customer(card.getIdCustomer(), cardResult.getIdCard());
        	customerRepository.save(customer);
        	
        	cardResponse.setMessage("Tarjeta Registrada");
        	cardResponse.setSuccess(true);
          	
        }
        else
        {
        	cardResponse.setMessage("La Tarjeta no pudo ser Registrada");
        	cardResponse.setSuccess(false);
        }
    	    	
    	return ResponseEntity.ok(cardResponse);
    }
    

    

}
