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

import com.ait.entity.ReviewEntity;
import com.ait.service.ReviewService;

@RestController
@RequestMapping("/reviwes")
public class ReviewController {
	
	@Autowired	
	private ReviewService reviewService;
	
	@PostMapping("/{id}")
	public ResponseEntity<?> addReview(@PathVariable Integer id,@RequestBody ReviewEntity review){
		reviewService.createReview(id, review);
		return new ResponseEntity<>("review Added successfully",HttpStatus.OK);
	}
	@GetMapping("/{companyId}")
	public ResponseEntity<?> getAllReviews(@PathVariable Integer companyId){
		List<ReviewEntity> reviews = reviewService.getReviews(companyId);
		return new ResponseEntity<>(reviews,HttpStatus.OK);
	}
	@GetMapping("/get/{reviewId}")
	public ResponseEntity<?> getReview(@PathVariable Integer reviewId){
		ReviewEntity review = reviewService.getReview(reviewId);
		if(review!=null) {
			return new ResponseEntity<>(review,HttpStatus.OK);
		}
		return new ResponseEntity<>("review not found",HttpStatus.NOT_FOUND);
	}
	@PutMapping("/get/{reviewId}")
	public ResponseEntity<?> updateReview(@PathVariable Integer reviewId,@RequestBody ReviewEntity entity){
     boolean status = reviewService.updateReview(reviewId, entity);
		if(status) {
			return new ResponseEntity<>("review updated sucessfully",HttpStatus.OK);
		}
		return new ResponseEntity<>("review not found",HttpStatus.NOT_FOUND);
	}
	@DeleteMapping("/delete/{reviewId}")
	public ResponseEntity<?> deleteReview(@PathVariable Integer reviewId){
     boolean status = reviewService.deleteReview(reviewId);
		if(status) {
			return new ResponseEntity<>("review deleted",HttpStatus.OK);
		}
		return new ResponseEntity<>("review not found",HttpStatus.NOT_FOUND);
	}
}
