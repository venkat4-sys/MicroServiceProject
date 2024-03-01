package com.ait.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ait.entity.ReviewEntity;
import java.util.List;


public interface ReviewRepo extends JpaRepository<ReviewEntity, Integer>{
	
	List<ReviewEntity> findByCompanyId(Integer companyId); 

}
