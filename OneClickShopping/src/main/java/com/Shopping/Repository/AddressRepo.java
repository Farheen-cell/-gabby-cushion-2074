package com.Shopping.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Shopping.Model.Address;

@Repository
public interface AddressRepo extends JpaRepository<Address, Integer>{

	
}
