package com.gabby.Service;

import com.gabby.Exception.AdminException;
import com.gabby.Exception.CurrentAdminSessionException;
import com.gabby.model.Admin;
import com.gabby.model.CurrentAdminSession;

public interface CurrentAdminSessionService {

	public CurrentAdminSession getCurrentAdminSession(String key) throws CurrentAdminSessionException;

	public Admin getAdminDetails(String key) throws AdminException, CurrentAdminSessionException;

	public Integer getAdminId(String key) throws CurrentAdminSessionException;
}
