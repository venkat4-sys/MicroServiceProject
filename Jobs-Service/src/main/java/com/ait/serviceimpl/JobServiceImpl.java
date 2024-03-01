package com.ait.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ait.dto.Company;
import com.ait.dto.Job;
import com.ait.dto.JobWithCompany;
import com.ait.dto.ReviewDto;
import com.ait.entity.JobEntity;
import com.ait.entity.ReviewEntity;
import com.ait.feign.CompanyFeign;
import com.ait.feign.ReviewFeign;
import com.ait.model.JobDto;
import com.ait.repo.JobRepo;
import com.ait.service.JobService;

@Service
public class JobServiceImpl implements JobService{
	
	@Autowired
	private JobRepo jobrepo;
	
	@Autowired
	private CompanyFeign companyFeign;
	
	@Autowired
	private ReviewFeign reeviewFeign;
	

	@Override
	public String createJob(JobEntity entity) {
		
	jobrepo.save(entity);
		return "job created successfully";
	}
	
	@Override
	public boolean deleteJobId(Integer id) {
		Optional<JobEntity> findById = jobrepo.findById(id);
            if(findById.isPresent()) {
            	Integer id2 = findById.get().getId();
            	jobrepo.deleteById(id2);
            	return true;
            }
		
		return false;
	}
	@Override
	public List<JobWithCompany> getAllJobs() {
		 List<JobEntity> jobs = jobrepo.findAll();
		 ArrayList listofjobs=new ArrayList();
		 for(JobEntity job:jobs) {
			 JobWithCompany jobcompany = jobcompany(job);
			 
			 
			 
			 listofjobs.add(jobcompany);
			 
		 }
		 return listofjobs;
		
	}
	public JobWithCompany jobcompany(JobEntity entity) {
		
		Company company = companyFeign.getCompanyById(entity.getCompanyId());
		 List<ReviewEntity> allReviews = reeviewFeign.getAllReviews(entity.getCompanyId());
		JobWithCompany jobWithCompanydto=new JobWithCompany();
		jobWithCompanydto.setCompany(company);
		Job job=new Job();
		BeanUtils.copyProperties(entity, job);
		jobWithCompanydto.setJob(job);
		ArrayList reviews=new ArrayList<>();
		for(ReviewEntity reviewentity :allReviews) {
			ReviewDto reviewdto=new ReviewDto();
			BeanUtils.copyProperties(reviewentity, reviewdto);
			reviews.add(reviewdto);	
		}
		jobWithCompanydto.setReview(reviews);
		return jobWithCompanydto;
		
	     
	}
	@Override
	public JobWithCompany getJobById(Integer id) {
		Optional<JobEntity> findById = jobrepo.findById(id);
		if(findById.isPresent()) {
			JobEntity jobentity = findById.get();
			JobWithCompany jobcompany = jobcompany(jobentity);
			return jobcompany;
		}
		return null;
	}
	@Override
	public JobEntity UpdateJob(Integer id, JobDto jobdto) {
		Optional<JobEntity> findById = jobrepo.findById(id);
		if(findById.isPresent()) {
			JobEntity jobEntity = findById.get();
			jobEntity.setDescription(jobdto.getDescription());
			jobEntity.setLocation(jobdto.getLocation());
			jobEntity.setMaxSalary(jobdto.getMaxSalary());
			jobEntity.setMinSalary(jobdto.getMinSalary());
			jobEntity.setTitle(jobdto.getTitle());
			jobEntity.setCompanyId(jobdto.getCompanyId());
			JobEntity job = jobrepo.save(jobEntity);
			return job;
		}
		return null;
	}

}
