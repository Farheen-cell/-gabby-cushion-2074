package com.Shopping.Services;

import com.Shopping.Exceptions.CustomerException;
import com.Shopping.Exceptions.LoginException;
import com.Shopping.Model.Address;
import com.Shopping.Model.Customer;

public interface customerService {

	public Customer AddCustomer(Customer customer) throws CustomerException;
	
	public Customer updateCustomer(String key,Customer customer)throws CustomerException,LoginException;
	
	public Address AddAddress(Address address,String key,Integer CustomerId)throws CustomerException,LoginException;
	
	public String deleteCustomer(Integer customerId, String key)throws CustomerException,LoginException;
	
}
