package com.gabby.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.gabby.model.CurrentAdminSession;



public interface SessionRepo  extends JpaRepository<CurrentAdminSession, Integer>{

	
	public CurrentAdminSession findByuuid(String uuid);
	
}
