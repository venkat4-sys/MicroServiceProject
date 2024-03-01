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

import com.ait.entity.CompanyEntity;
import com.ait.service.CompanyService;

@RestController
@RequestMapping("/Company")
public class CompanyController {
	
	@Autowired
	private CompanyService CompanyService;
	
	@PostMapping("/createCompany")
	public ResponseEntity<?> createCompany(@RequestBody CompanyEntity enity) {
		String message = CompanyService.createCompany(enity);
		return new ResponseEntity<String>(message, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getCompanyById(@PathVariable Integer id) {
		 CompanyEntity company = CompanyService.getCompanyById(id);
		 if(company!=null) {
			 return new ResponseEntity<CompanyEntity>(company, HttpStatus.OK); 
		 }
		 return new ResponseEntity<>("company not found", HttpStatus.NOT_FOUND);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCompanyById(@PathVariable Integer id) {
		boolean status = CompanyService.deleteCompanyId(id);
		if (status) {
			return new ResponseEntity<>("company deleted successfully" + " " + id, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	@GetMapping("/all")
	public ResponseEntity<?> getAllCompanies() {
	 List<CompanyEntity> Companies = CompanyService.getAllCompanies();
		return new ResponseEntity<>(Companies, HttpStatus.OK);
	}
	@PutMapping("/{id}")
	public ResponseEntity<?> updateCompany(@PathVariable Integer id,@RequestBody CompanyEntity entity){
		CompanyEntity company = CompanyService.UpdateCompany(id, entity);
		return new ResponseEntity<>(company, HttpStatus.OK);
	}
}
