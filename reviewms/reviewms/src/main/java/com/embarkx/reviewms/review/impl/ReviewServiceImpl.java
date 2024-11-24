package com.embarkx.reviewms.review.impl;


import com.embarkx.reviewms.review.Review;
import com.embarkx.reviewms.review.ReviewRepository;
import com.embarkx.reviewms.review.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl  implements ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public List<Review> getAllReviewsForACompany(Long companyId) {
       return reviewRepository.findByCompanyId(companyId);
    }

    @Override
    public Review createReviewForACompany(Long companyId, Review review) {

        review.setCompanyId(companyId);
    Review r= reviewRepository.save(review);
    return r;
    }

    @Override
    public Review getReviewByReviewId(Long reviewId) {
    return reviewRepository.findById(reviewId).orElse(null);
    }

    @Override
    public Review updateReviewForACompany(Long ReviewId, Review review) {
      Review r=reviewRepository.findById(ReviewId).orElse(null);
      if(r!=null){
          r.setCompanyId(review.getCompanyId());
          r.setDescription(review.getDescription());
          r.setRating(review.getRating());
          r.setTitle(review.getTitle());
         return  reviewRepository.save(r);
      }
      return null;
    }

    @Override
    public Review deleteReviewByReviewId(long reviewId) {
Review r=reviewRepository.findById(reviewId).orElse(null);
if(r!=null){
    reviewRepository.delete(r);
}
return r;
   }





}
