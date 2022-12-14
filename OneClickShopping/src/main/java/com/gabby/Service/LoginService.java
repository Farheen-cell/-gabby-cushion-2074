package com.gabby.Service;

import com.gabby.Exception.LoginException;
import com.gabby.model.Login;

public interface LoginService {
	
	
	public String logIntoAccount(Login dto)throws LoginException;

	public String logOutFromAccount(String key)throws LoginException;
	

}
