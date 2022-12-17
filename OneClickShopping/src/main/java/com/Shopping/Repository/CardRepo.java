package com.Shopping.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Shopping.Model.CardDetails;

public interface CardRepo extends JpaRepository<CardDetails, Integer>{

}
