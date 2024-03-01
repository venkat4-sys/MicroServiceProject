package com.ait.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ait.entity.CompanyEntity;

public interface CompanyRepo extends JpaRepository<CompanyEntity, Integer>{
	
}
