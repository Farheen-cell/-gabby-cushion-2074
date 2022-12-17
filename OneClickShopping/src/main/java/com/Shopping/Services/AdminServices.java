package com.Shopping.Services;

import com.Shopping.Exceptions.AdminException;
import com.Shopping.Exceptions.LoginException;
import com.Shopping.Model.Admin;

public interface AdminServices {

	public Admin addadmin(Admin admin) throws AdminException;
	
	public Admin updateAdmin(Admin admin,String key) throws LoginException,AdminException;
	
	public String deleteAdmin(Integer adminId,String key)
			throws LoginException,AdminException;
	
	public Admin getAdminById(Integer adminId,String key)
			throws LoginException,AdminException;
}
