package com.ait.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ait.dto.JobWithCompany;
import com.ait.entity.JobEntity;
import com.ait.model.JobDto;
import com.ait.service.JobService;

@RestController
@RequestMapping("/jobs")
public class JobController {

	@Autowired
	private JobService jobservice;

	@PostMapping("/createJob")
	public ResponseEntity<?> createJob(@RequestBody JobEntity enity) {
		String message = jobservice.createJob(enity);
		return new ResponseEntity<String>(message, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getjobById(@PathVariable Integer id) {
	JobWithCompany jobwithcompany = jobservice.getJobById(id);
		return new ResponseEntity<>(jobwithcompany, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteJobById(@PathVariable Integer id) {
		boolean status = jobservice.deleteJobId(id);
		if (status) {
			return new ResponseEntity<>("job deleted successfully" + " " + id, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@GetMapping("/all")
	public ResponseEntity<?> getAllJobs() {
		 List<JobWithCompany> allJobs = jobservice.getAllJobs();
		return new ResponseEntity<>(allJobs, HttpStatus.OK);
	}
	@PutMapping("/{id}")
	public ResponseEntity<?> updateJob(@PathVariable Integer id,@RequestBody JobDto jobdto){
		JobEntity updateJob = jobservice.UpdateJob(id, jobdto);
		return new ResponseEntity<>(updateJob, HttpStatus.OK);
	}

}