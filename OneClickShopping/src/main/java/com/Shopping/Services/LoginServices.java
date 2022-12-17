package com.Shopping.Services;

import com.Shopping.Exceptions.LoginException;
import com.Shopping.Model.CurrentUserSession;
import com.Shopping.Model.Login;

public interface LoginServices {

	public CurrentUserSession customerlogin(Login log) throws LoginException;
	
	public CurrentUserSession sellerlogin(Login log) throws LoginException;

	public String Logout(Integer id , String uuid) throws LoginException;
	
	public CurrentUserSession adminlogin(Login log) throws LoginException;
}
