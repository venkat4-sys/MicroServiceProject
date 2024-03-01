package com.ait.service;

import java.util.List;

import com.ait.entity.ReviewEntity;

public interface ReviewService {
	
	public void createReview(Integer companyId,ReviewEntity entity);
	
	public List<ReviewEntity> getReviews(Integer companyId);
	
	public ReviewEntity getReview(Integer reviewId);
    
    public boolean updateReview(Integer reviewId,ReviewEntity review);
    
    public boolean deleteReview(Integer reviewId);
}
