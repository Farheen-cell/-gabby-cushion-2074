package com.gabby.Controller;


import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gabby.Exception.CustomerException;
import com.gabby.Exception.LoginException;
import com.gabby.Service.CustomerService;
import com.gabby.Service.LoginService;
import com.gabby.model.Customer;
import com.gabby.model.Login;



//@CrossOrigin(origins = "*")
@RestController
//@RequestMapping("/user")
public class UserController {

	
	
	@Autowired
	private CustomerService cus;
	
	@Autowired
	private LoginService login;
	
	
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@Valid @RequestBody Login log) throws CustomerException, LoginException
	{
		
		String s = login.logIntoAccount(log);
		
		return new ResponseEntity<String>(s, HttpStatus.OK);
	}
	
	@DeleteMapping("/logout")
	public ResponseEntity<String> logot(@RequestParam String key) throws CustomerException , LoginException
	{
		String s = login.logOutFromAccount(key);
		return new ResponseEntity<String>(s, HttpStatus.OK);
	}
	
	
	
	
	@PostMapping("/customers")
	 public ResponseEntity<Customer> addcustomer(@Valid @RequestBody Customer customer) throws  CustomerException
	 {
		 Customer addCustomer = cus.addCustomer(customer);
		 
		 return new ResponseEntity<Customer>(addCustomer, HttpStatus.CREATED);
	 }
	
	
	
	@PutMapping("/updacustomer/{key}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable("key") String key, @RequestBody Customer customer) throws LoginException,CustomerException, javax.security.auth.login.LoginException
	{
	Customer update =cus.updateCust(customer, key);
		
		
		
		return new ResponseEntity<Customer>(update, HttpStatus.CREATED);
	}
	
	 @GetMapping("/getdeta")
	   public ResponseEntity<Customer> getbyid(@RequestBody Customer p)throws CustomerException{
		   
		   Customer f = cus.viemCustomer(p.getCustomerId());
		   
		   return new ResponseEntity<Customer>(f,HttpStatus.ACCEPTED);
		   
		   
	   }
}
