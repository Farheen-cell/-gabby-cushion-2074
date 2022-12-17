package com.Shopping.Services;

import java.util.List;

import com.Shopping.Exceptions.CardException;
import com.Shopping.Exceptions.CustomerException;
import com.Shopping.Exceptions.LoginException;
import com.Shopping.Model.CardDetails;

public interface CardServices {

	public CardDetails addcard(CardDetails card,String key,Integer customerId) 
			throws CardException,LoginException,CustomerException;
	
	public String deleteCard(Integer cardId,String Key,Integer customerId)
			throws CardException,LoginException,CustomerException;
	
	public CardDetails getCardByCardId(Integer cardId,String key, Integer customerId)
			throws CardException,LoginException,CustomerException;
	
	public List<CardDetails> getAllCardByCustomerId(String key, Integer customerId)
			throws CardException,LoginException,CustomerException;
	
}
