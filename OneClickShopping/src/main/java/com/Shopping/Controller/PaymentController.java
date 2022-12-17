package com.Shopping.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Shopping.Exceptions.CardException;
import com.Shopping.Exceptions.CustomerException;
import com.Shopping.Exceptions.LoginException;
import com.Shopping.Exceptions.OrderException;
import com.Shopping.Exceptions.PaymentException;
import com.Shopping.Model.Payment;
import com.Shopping.Services.paymentServices;

@RestController
public class PaymentController {

	@Autowired
	private paymentServices pservice;
	
	@PostMapping("/makePayments")
	public ResponseEntity<Payment> MakePaymentHandler(@RequestParam Integer orderId,@RequestParam Integer cardId,@RequestParam Integer customerId,@RequestParam String key)
			throws LoginException, CustomerException, OrderException, PaymentException, CardException{
		
		Payment pay = pservice.makePayment(orderId, cardId, customerId, key);
		
		return new ResponseEntity<Payment>(pay,HttpStatus.OK);
	}
	
	@GetMapping("/viewPayment/{paymentId}")
	public ResponseEntity<Payment> viewPaymentDetailsHandler(@PathVariable Integer paymentId,@RequestParam Integer customerId,@RequestParam String key)
			throws LoginException, CustomerException, OrderException, PaymentException {
		
		Payment pay = pservice.viewPaymentDetailsById(paymentId, customerId, key);
		
		return new ResponseEntity<Payment>(pay,HttpStatus.OK);
	}
	
	@GetMapping("/viewAllPayments")
	public ResponseEntity<List<Payment>> viewAllPaymentDetailsHandler(@RequestParam Integer customerId,@RequestParam String key)
			throws LoginException, CustomerException, OrderException, PaymentException {
		
		List<Payment> pay = pservice.getAllPaymentByCustomer(customerId, key);
		
		return new ResponseEntity<List<Payment>>(pay,HttpStatus.OK);
	}
	
	
	public ResponseEntity<String> cancelPaymentHandler(@PathVariable Integer paymentId,@RequestParam Integer customerId,@RequestParam String key)
			throws LoginException, CustomerException, OrderException, PaymentException {
		
		String message = pservice.cancelPayment(paymentId, customerId, key);
		
		
		return new ResponseEntity<String>(message,HttpStatus.ACCEPTED);
	}
	
}
