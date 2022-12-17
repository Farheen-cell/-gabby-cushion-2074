package com.Shopping.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Shopping.Exceptions.CustomerException;
import com.Shopping.Exceptions.FeedBackException;
import com.Shopping.Exceptions.LoginException;
import com.Shopping.Exceptions.OrderException;
import com.Shopping.Model.Feedback;
import com.Shopping.Services.FeedBackService;

@RestController
public class FeedBackController {

	@Autowired
	private FeedBackService fServices;
	
	@PostMapping("addFeedBack")
	public ResponseEntity<Feedback> addFeedBackHandler(@Valid @RequestBody Feedback feedback,@RequestParam Integer orderId,@RequestParam Integer customerId,@RequestParam String key)
			throws LoginException,CustomerException,OrderException,FeedBackException{
		
		Feedback feed = fServices.AddFeedBack(feedback, orderId, customerId, key);
		
		return new ResponseEntity<Feedback>(feed,HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/updatefeedback")
	public ResponseEntity<Feedback> updateFeedBackHandler(@RequestBody Feedback feedback,@RequestParam Integer customerId,@RequestParam String key)
			throws LoginException,CustomerException,OrderException,FeedBackException{
		
		Feedback feed = fServices.updateFeedback(feedback, customerId, key);
		
		return new ResponseEntity<Feedback>(feed,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/deletefeedback")
	public ResponseEntity<String> deleteFeedBackHandler(@RequestParam Integer feedbackId,@RequestParam Integer customerId,@RequestParam String key)
			throws LoginException,CustomerException,OrderException,FeedBackException{
		
		String feed = fServices.deletefeedback(feedbackId, customerId, key);
		
		return new ResponseEntity<String>(feed,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/viewAllfeedback/{customerId}")
	public ResponseEntity<List<Feedback>> viewAllFeedBackHandler(@PathVariable Integer customerId,@RequestParam String key)
			throws LoginException,CustomerException,OrderException,FeedBackException{
		
		List<Feedback> feed = fServices.viewAllFeedback(customerId, key);
		
		return new ResponseEntity<List<Feedback>>(feed,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/viewAllfeedbackById/{customerId}")
	public ResponseEntity<Feedback> viewAllFeedBackByIdHandler(@RequestParam Integer feedbackId,@PathVariable Integer customerId,@RequestParam String key)
			throws LoginException,CustomerException,OrderException,FeedBackException{
		
		Feedback feed = fServices.viewFeedBackById(feedbackId, customerId, key);
		
		return new ResponseEntity<Feedback>(feed,HttpStatus.ACCEPTED);
	}
	
}
