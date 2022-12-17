package com.Shopping.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Shopping.Model.Payment;

@Repository
public interface PaymentRepo extends JpaRepository<Payment, Integer>{

}
