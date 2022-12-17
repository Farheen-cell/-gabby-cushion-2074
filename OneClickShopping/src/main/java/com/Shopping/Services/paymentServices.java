package com.Shopping.Services;

import java.util.List;

import com.Shopping.Exceptions.CardException;
import com.Shopping.Exceptions.CustomerException;
import com.Shopping.Exceptions.LoginException;
import com.Shopping.Exceptions.OrderException;
import com.Shopping.Exceptions.PaymentException;
import com.Shopping.Model.Payment;

public interface paymentServices {

	public Payment makePayment(Integer orderId,Integer cardId,Integer customerId,String key) 
			throws LoginException,CustomerException,OrderException,PaymentException,CardException;
	
	public Payment viewPaymentDetailsById(Integer paymentId,Integer customerId,String key)
			throws LoginException,CustomerException,OrderException,PaymentException;
	
	public List<Payment> getAllPaymentByCustomer(Integer customerId,String key)
			throws LoginException,CustomerException,OrderException,PaymentException;
	
	public String cancelPayment(Integer payId,Integer customerId,String key)
			throws LoginException,CustomerException,OrderException,PaymentException;
}
