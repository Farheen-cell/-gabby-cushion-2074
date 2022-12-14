package com.gabby.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.gabby.model.Admin;



public interface AdminRepo  extends JpaRepository<Admin, Integer>{
	
	public Admin findByemail(String email);

}