package com.gabby.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gabby.model.CurrentCustomerSession;

@Repository
public interface CurrentCustomerSessionRepo extends JpaRepository<CurrentCustomerSession, Integer>{

	public Optional<CurrentCustomerSession> findByKey(String key);

	public Optional<CurrentCustomerSession> findByCustomerId(Integer customerId);
}
