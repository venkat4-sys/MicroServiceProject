package com.ait.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ait.entity.JobEntity;

public interface JobRepo extends JpaRepository<JobEntity, Integer>{

}
