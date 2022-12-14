package com.gabby.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.gabby.model.Session;



public interface SessionRepo  extends JpaRepository<Session, Integer>{

	
	public Session findByuuid(String uuid);
	
}
