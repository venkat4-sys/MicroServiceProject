package com.ait.service;

import java.util.List;

import com.ait.entity.JobEntity;
import com.ait.model.JobDto;


public interface JobService {
	
	public String createJob(JobEntity entity);
	
	public JobEntity getJobById(Integer id);
	
	public List<JobEntity> getAllJobs();
	
	public boolean deleteJobId(Integer id);
	
	public JobEntity UpdateJob(Integer id,JobDto jobdto); 

}
