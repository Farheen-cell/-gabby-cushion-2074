package com.Shopping.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Shopping.Model.Cart;

@Repository
public interface CartRepo extends JpaRepository<Cart, Integer>{

	
}
