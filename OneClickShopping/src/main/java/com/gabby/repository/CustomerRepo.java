package com.gabby.repository;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gabby.Exception.CustomerException;
import com.gabby.model.Customer;





public interface CustomerRepo extends JpaRepository<Customer, Integer>{


	public Optional<Customer> findBymobilenumber(String mobileNumber) throws CustomerException;
	public Customer findByemail(@NotNull(message = "Email Id can't be null..") String email);
	
	
}