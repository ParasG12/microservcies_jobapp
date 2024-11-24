package com.embarx.firstjobapp.review;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReviewsForACompany(Long companyId);
    Review createReviewForACompany(Long companyId, Review review);
Review getReviewByReviewId(Long companyId, Long reviewId);
Review updateReviewForACompany(Long companyId, Long ReviewId,Review review);
Review deleteReviewByReviewId(long companyId,long reviewId);

}
