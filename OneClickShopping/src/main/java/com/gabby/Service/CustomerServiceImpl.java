package com.gabby.Service;


import java.util.List;

import java.util.Optional;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabby.Exception.CustomerException;
import com.gabby.model.Customer;
import com.gabby.model.Session;
import com.gabby.repository.CustomerRepo;
import com.gabby.repository.SessionRepo;



@Service
public class CustomerServiceImpl  implements CustomerService{

	
	 @Autowired
	  private CustomerRepo cus;
	
	 @Autowired
	  private SessionRepo sdo;
	
	
	
	
	@SuppressWarnings("unused")
	@Override
	public Customer addCustomer(Customer customer) throws CustomerException {
		// TODO Auto-generated method stub
		
		 Optional<Customer> s = cus.findById(customer.getCustomerId());
		
		 if(customer == null)
		 {
			 throw new CustomerException("Please Provide all valid Exception");
		 }
		 if(s.isPresent())
		  {
			  throw new CustomerException("Customer Already Exist");
		  }
		  else
		  {
			 return  cus.save(customer);
		  }
	}





	@Override
	public Customer updateCust(Customer customer, String key) throws CustomerException, LoginException {


		Session s = sdo.findByuuid(key);
		if(s==null)
		{
			throw new LoginException("You are not authoridzed to update this ");
		}
      else if( customer.getMobilenumber().toCharArray().length != 10 ){
			
			throw new CustomerException("Mobile Number can only be of 10 digit");
		}
		
		if(customer.getCustomerId() ==s.getUserId()) {
			return cus.save(customer) ;
		}
		else {
			throw new CustomerException("Can't change UserID!") ;
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
	}


	

@Override
public Customer removeCustomer(Customer customer, String key) throws CustomerException, LoginException {
	// TODO Auto-generated method stub
	Session s = sdo.findByuuid(key);
	if(s==null)
	{
		throw new LoginException("You are not authoridzed Delete this ");
	}
	else
	{
		Optional<Customer> ss = cus.findById(customer.getCustomerId());
		
		 Customer sss = ss.get();
		 
		   cus.deleteById(customer.getCustomerId());
		return sss;
	}

	
}


	@Override
	public Customer viemCustomer(Integer cusInteger) throws CustomerException {
			// TODO Auto-generated method stub
			Optional<Customer> ss = cus.findById(cusInteger);
			
			 Customer sss = ss.get();
			return sss;
		}

	
	
	



@Override
public List<Customer> viewAll(String location) throws CustomerException {
	List<Customer> c= cus.findByAddress(location);
	
	if(c.isEmpty())
		throw new CustomerException("No Student found with Address :"+location);
	
	
	return c;
}

}	
	

