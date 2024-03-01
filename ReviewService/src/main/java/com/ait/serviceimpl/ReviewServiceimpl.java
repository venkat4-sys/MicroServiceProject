package com.ait.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ait.entity.ReviewEntity;
import com.ait.repo.ReviewRepo;
import com.ait.service.ReviewService;

@Service
public class ReviewServiceimpl implements ReviewService {

	@Autowired
	private ReviewRepo reviewrepo;

	@Override
	public void createReview(Integer companyId, ReviewEntity entity) {

		if (companyId != null && entity != null) {
			entity.setCompanyId(companyId);
			reviewrepo.save(entity);

		}
	}

	@Override
	public List<ReviewEntity> getReviews(Integer companyId) {
		List<ReviewEntity> reviews = reviewrepo.findByCompanyId(companyId);

		return reviews;
	}

	@Override
	public ReviewEntity getReview(Integer reviewId) {
		Optional<ReviewEntity> reviews = reviewrepo.findById(reviewId);
		if (reviews.isPresent()) {
			ReviewEntity review = reviews.get();
			return review;
		}
		return null;
	}

	@Override
	public boolean updateReview(Integer reviewId, ReviewEntity review) {

		if (reviewId != null && review != null) {
			Optional<ReviewEntity> findById = reviewrepo.findById(reviewId);

			if (findById.isPresent()) {
				ReviewEntity reviewEntity = findById.get();
				reviewEntity.setTitle(review.getTitle());
				reviewEntity.setDescription(review.getDescription());
				reviewEntity.setRating(review.getRating());
				reviewrepo.save(reviewEntity);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean deleteReview(Integer reviewId) {

		reviewrepo.deleteById(reviewId);
		return true;
	}
}
