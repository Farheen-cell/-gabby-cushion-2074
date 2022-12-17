package com.Shopping.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Shopping.Model.Seller;

@Repository
public interface sellerRepo extends JpaRepository<Seller, Integer>{

	public Seller findByEmail(String Email);
}
