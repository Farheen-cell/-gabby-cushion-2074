package com.masai.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.Customer;
@Repository
public interface CustomerDao extends JpaRepository<Customer, Integer>{

	public Customer findByMobileNo(String mobileNo);

}
