package com.cardService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
  	      value = "/registerCard",
  	      method = RequestMethod.POST,
  	      produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CardResponse> registerOrder(@RequestBody CardRequest cardRequest) {

    	CreditCard card = new CreditCard(cardRequest.getIdCustomer(), cardRequest.getNumberCard(), cardRequest.getCardType(), cardRequest.getExpirationMonth(), cardRequest.getExpirationYear());
    	         
    	CreditCard cardResult = new CreditCard();
    	CardResponse cardResponse = new CardResponse("", false);
    	
        if(customerRepository.existsById(card.getIdCustomer()))
        {
        	cardResult = cardRepository.save(card);
        	
        	Customer customerResult =  customerRepository.getOne(card.getIdCustomer());
        	customerResult.setIdCard(card.getIdCard());
        	customerRepository.save(customerResult);
        	
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
