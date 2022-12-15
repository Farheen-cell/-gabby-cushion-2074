package com.gabby.Service;


import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabby.Exception.AdminException;
import com.gabby.Exception.LoginException;
import com.gabby.model.Admin;
import com.gabby.model.Customer;
import com.gabby.model.Login;
import com.gabby.model.CurrentAdminSession;
import com.gabby.repository.AdminRepo;
import com.gabby.repository.CustomerRepo;
import com.gabby.repository.SessionRepo;

import net.bytebuddy.utility.RandomString;
@Service
public class LoginServiceImpl  implements LoginService{

	
	 
	@Autowired
	private CustomerRepo cus;
	
	@Autowired
	private SessionRepo ses;
	
	
	@Autowired
	private AdminRepo ad;
	
	@Override
	public String logIntoAccount(Login dto) throws LoginException {
		// TODO Auto-generated method stub
		
		  if(dto.getRoll().equalsIgnoreCase("admin"))
		  {
			  Admin ads  = ad.findByemail(dto.getEmail());
			  
			  if(ads == null)
			  {
				  throw new LoginException("Login failed Pleas try again");
			  }
			  
			  Optional<CurrentAdminSession> validCustomerSessionOpt =  ses.findById(ads.getAdminId());
			  
			  if(validCustomerSessionOpt.isPresent()) {
					
					throw new LoginException("User already Logged In with this number");
					
				}
			  
			  
			     if(ads.getPassword().equals(dto.getPassword()))
			     {
			    	 String key= RandomString.make(6);
			    	 
			    	 CurrentAdminSession ss = new CurrentAdminSession(ads.getAdminId(), key, LocalDateTime.now());
			    	 
			    	 ses.save(ss);
			    	 return ss.toString();
			     }
			     else
			     {
			    	 throw new LoginException("Please Enter a valid password");
			     }
			  
			      
			  
		  }
		  else
		  {
			  Customer existingCustomer=  cus.findByemail(dto.getEmail());
			  
			 
			  if(existingCustomer == null) {
					
					throw new LoginException("Please Enter a valid email  and password");
					
					 
				}
			  
			  
			  Optional<CurrentAdminSession> validCustomerSessionOpt =  ses.findById(existingCustomer.getCustomerId());
			  
			  
			  if(validCustomerSessionOpt.isPresent()) {
					
					throw new LoginException("User already Logged In with this number");
					
				}
			  
			  
			  if(existingCustomer.getPassword().equals(dto.getPassword())) {
					
					String key= RandomString.make(6);
					
					
					
					CurrentAdminSession currentUserSession = new CurrentAdminSession(existingCustomer.getCustomerId(),key,LocalDateTime.now());
					
					ses.save(currentUserSession);

					return currentUserSession.toString();
				}
			  else
			  {
				  throw new LoginException("Pleas enter the valid email or password");
			  }
			  
		  }
	}

	@Override
	public String logOutFromAccount(String key) throws LoginException {
		// TODO Auto-generated method stub
		CurrentAdminSession validCustomerSession = ses.findByuuid(key);
		if(validCustomerSession == null) {
			throw new LoginException("User Not Logged In with this number");
			
		}
ses.delete(validCustomerSession);
		
		
		return "Logged Out !";
	}

}
