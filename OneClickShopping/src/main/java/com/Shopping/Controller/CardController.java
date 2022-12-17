package com.Shopping.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Shopping.Exceptions.CardException;
import com.Shopping.Exceptions.CustomerException;
import com.Shopping.Exceptions.LoginException;
import com.Shopping.Model.CardDetails;
import com.Shopping.Services.CardServices;

@RestController
public class CardController {

	@Autowired
	private CardServices cService;
	
	@PostMapping("/AddCard")
	public ResponseEntity<CardDetails> AddCardHandler(@Valid @RequestBody CardDetails card,@RequestParam String key,@RequestParam Integer customerId)
			throws CardException, LoginException, CustomerException{
		
		CardDetails savedCard = cService.addcard(card, key, customerId);
		
		return new ResponseEntity<CardDetails>(savedCard,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/deleteCard")
	public ResponseEntity<String> deleteCardHandler(@RequestParam Integer cardId,@RequestParam String key,@RequestParam Integer customerId) 
			throws CardException, LoginException, CustomerException{
		
		String message= cService.deleteCard(cardId, key, customerId);
		
		return new ResponseEntity<String>(message,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/getCardById")
	public ResponseEntity<CardDetails> getCardByIdHandler(@RequestParam Integer cardId,@RequestParam String key,@RequestParam Integer customerId)
			throws CardException, LoginException, CustomerException{
		
		CardDetails card= cService.getCardByCardId(cardId, key, customerId);
		
		return  new ResponseEntity<CardDetails>(card,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/getAllCard")
	public ResponseEntity<List<CardDetails>> getAllCardByCustomerIdHandler(@RequestParam String key,@RequestParam Integer customerId)
			throws CardException, LoginException, CustomerException{
		
		List<CardDetails> cardlist= cService.getAllCardByCustomerId(key, customerId);
		
		return new ResponseEntity<List<CardDetails>>(cardlist,HttpStatus.ACCEPTED);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
