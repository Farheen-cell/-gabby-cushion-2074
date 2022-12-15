package com.gabby.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gabby.model.Orders;

@Repository
public interface OrderRepo extends JpaRepository<Orders, Integer>{
	
	
	@Query("select o from Order o where o.orderDate =?1")
	public List<Orders> getOrderDate(LocalDate date);
	
	@Query("select o from Order o innerjoin Address a where a.city =?1")
	public List<Orders> getviewAllOrderByLocation(String address);
	
	@Query("select o from Order o innerjoin Customer c where c.customerId = ?1")
	public List<Orders> getviewOrderByUserId(String userId);
}
