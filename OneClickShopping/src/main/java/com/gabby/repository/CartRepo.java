package com.gabby.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gabby.model.Cart;
import com.gabby.model.Customer;

@Repository
public interface CartRepo extends JpaRepository<Cart, Integer>{
	
	public Optional<Cart> findByCustomer(Customer customer);
}
