package com.ait.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ait.entity.ReviewEntity;

@FeignClient(name="ReviewService")
public interface ReviewFeign {
	
	@GetMapping("/reviwes/{companyId}")
	public List<ReviewEntity> getAllReviews(@PathVariable Integer companyId);
	

}
