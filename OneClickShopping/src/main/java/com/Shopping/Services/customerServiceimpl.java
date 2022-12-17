package com.Shopping.Services;

import java.lang.StackWalker.Option;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Shopping.Exceptions.CustomerException;
import com.Shopping.Exceptions.LoginException;
import com.Shopping.Model.Address;
import com.Shopping.Model.Cart;
import com.Shopping.Model.CurrentUserSession;
import com.Shopping.Model.Customer;
import com.Shopping.Model.Feedback;
import com.Shopping.Model.Order;
import com.Shopping.Model.Products;
import com.Shopping.Repository.AddressRepo;
import com.Shopping.Repository.CurrentUserSessionRepo;
import com.Shopping.Repository.CustomerRepo;
import com.Shopping.Repository.FeedBackRepo;

@Service
public class customerServiceimpl implements customerService{

	@Autowired
	private CustomerRepo crepo;
	
	@Autowired
	private AddressRepo arepo; 
	
	@Autowired
	private CurrentUserSessionRepo cusr;
	
	@Autowired
	private FeedBackRepo frepo;
	
	@Override
	public Customer AddCustomer(Customer customer) throws CustomerException {
		Customer cust = crepo.findByEmail(customer.getEmail());
		
		if(cust!=null) throw new CustomerException("Customer with this Email already Exist");
		
		Cart cart=new Cart();
		cart.setCartValue(0);
		cart.setProducts(new HashMap<Products,Integer>());
		
		customer.setCart(cart);
		cart.setCustomer(customer);
		Customer newCustomer=crepo.save(customer);
		return newCustomer;
	}

	@Override
	public Customer updateCustomer(String key, Customer customer) throws CustomerException, LoginException {
		
		Optional<Customer> opt= crepo.findById(customer.getCustomerId());
		
		if(opt.isEmpty()) throw new CustomerException("Invalid Credentials...."); 
		
		if(crepo.findByEmail(customer.getEmail())==null) 
			throw new CustomerException("Invalid Email Id");
		
		CurrentUserSession cus= cusr.findByUuid(key);
		if(cus==null) throw new LoginException("Please Login First");
		
		Customer cust= opt.get();
//		cusr.delete(cus);
		customer.setCard(cust.getCard());
		customer.setAddress(cust.getAddress());
		customer.setOrderList(cust.getOrderList());
		customer.setCart(cust.getCart());
		
		crepo.save(customer);
		return cust;
	}

	@Override
	public String deleteCustomer(Integer customerId, String key) throws CustomerException, LoginException {
		CurrentUserSession cus= cusr.findByUuid(key);
		if(cus==null) throw new LoginException("Please Login First");
		
		if(customerId!=cus.getUserId()) throw new CustomerException("Invalid Credentials....");
		  
		 Customer cust = crepo.findById(customerId).get();
		 
		 deletefeedback(cust);
		 
		crepo.delete(cust);
		
		cusr.delete(cus);
		
		return "Thank You for Using Our Service "+cust.getFirstName();
	}

	@Override
	public Address AddAddress(Address address, String key, Integer customerId)
			throws CustomerException, LoginException {
		
		  CurrentUserSession cus= cusr.findByUuid(key);
		
		  if(cus==null) throw new LoginException("Enter Valid Key");
		  
		 Optional<Customer> opt=  crepo.findById(customerId);
		  
		 if(opt.isPresent()) {
			 
			 Customer cust= opt.get();
			 
			 cust.setAddress(address);
			 
//			 crepo.save(cust);
			 
			 Address addr= arepo.save(address);
			 
			 return addr;
			 
		 }else {
			 throw new CustomerException("Invalid Customer Id");
		 }
	}

	public void deletefeedback(Customer cust) {
		List<Feedback> list = frepo.findByCustomer(cust);
		
		for(Feedback f:list) {
			frepo.delete(f);
		}
		
	}
	
	
	
}
