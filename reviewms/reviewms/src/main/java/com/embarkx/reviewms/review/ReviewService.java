package com.embarkx.reviewms.review;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReviewsForACompany(Long companyId);
    Review createReviewForACompany(Long companyId, Review review);
Review getReviewByReviewId( Long reviewId);
Review updateReviewForACompany( Long ReviewId,Review review);
Review deleteReviewByReviewId(long reviewId);

}
