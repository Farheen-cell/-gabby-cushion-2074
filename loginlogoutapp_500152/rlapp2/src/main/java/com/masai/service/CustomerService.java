package com.masai.service;

import com.masai.exceptions.CustomerException;
import com.masai.model.Customer;

public interface CustomerService {
	
	
	public Customer createCustomer(Customer customer)throws CustomerException;
	
	public Customer updateCustomer(Customer customer,String key)throws CustomerException;

}
