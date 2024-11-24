package com.embarx.firstjobapp.review.impl;

import com.embarx.firstjobapp.company.Company;
import com.embarx.firstjobapp.company.CompanyService;
import com.embarx.firstjobapp.review.Review;
import com.embarx.firstjobapp.review.ReviewRepository;
import com.embarx.firstjobapp.review.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class ReviewServiceImpl  implements ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private CompanyService companyService;
    @Override
    public List<Review> getAllReviewsForACompany(Long companyId) {
       return reviewRepository.findByCompanyId(companyId);
    }

    @Override
    public Review createReviewForACompany(Long companyId, Review review) {
        Company company=companyService.getCompanyById(companyId);
        review.setCompany(company);
    Review r= reviewRepository.save(review);
    return r;
    }

    @Override
    public Review getReviewByReviewId(Long companyId, Long reviewId) {
       List<Review>reviews= reviewRepository.findByCompanyId(companyId);
       return reviews.stream().filter(r->r.getId().equals(reviewId)).findFirst().orElse(null);
    }

    @Override
    public Review updateReviewForACompany(Long companyId, Long ReviewId, Review review) {
        if(companyService.getCompanyById(companyId)!=null) {
           review.setCompany(companyService.getCompanyById(companyId));
           review.setId(ReviewId);
           return reviewRepository.save(review);
        }
        return null;
    }

    @Override
    public Review deleteReviewByReviewId(long companyId, long reviewId) {
   Review review=null;
   if(companyService.getCompanyById(companyId)!=null && reviewRepository.existsById(reviewId)) {
       review=reviewRepository.findById(reviewId).orElse(null);
       Company company=review.getCompany();
       company.getReviews().remove(review);
       review.setCompany(null);
       companyService.updateCompany(companyId,company);
       reviewRepository.delete(review);
       return review;
   }

   return null;
    }


}
