package com.gabby.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gabby.model.Admin;
import com.gabby.model.CurrentAdminSession;

@Repository
public interface CurrentAdminSessionRepo extends JpaRepository<CurrentAdminSession, Integer>{

	public Optional<CurrentAdminSession> findByKey(String key);

	public Optional<CurrentAdminSession> findByAdminId(Integer adminId);

}
