package com.ait.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ait.dto.Company;

@FeignClient(name="CompanyService")
public interface CompanyFeign {
	
	@GetMapping("/Company/{id}")
	public Company getCompanyById(@PathVariable Integer id);
	
	

}
