package com.embarkx.reviewms.review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;
    @GetMapping
    public ResponseEntity<?> getAllReviewsForACompany(@RequestParam("companyId")long companyId){
        return new ResponseEntity<>(reviewService.getAllReviewsForACompany(companyId), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> createReviewsForACompany(@RequestParam("companyId")Long companyId,@RequestBody Review review){
        return new ResponseEntity<>(reviewService.createReviewForACompany(companyId,review), HttpStatus.OK);
    }
    @GetMapping("/{reviewId}")
    public ResponseEntity<?> getReviewById(@PathVariable("reviewId") Long reviewId){
return new ResponseEntity<>(reviewService.getReviewByReviewId(reviewId), HttpStatus.OK);
    }
    @PutMapping("/{reviewId}")
    public ResponseEntity<?>updateReview(@PathVariable("reviewId")Long reviewId,@RequestBody Review review){
        return new ResponseEntity<>(reviewService.updateReviewForACompany(reviewId,review),HttpStatus.OK);
    }
    @DeleteMapping("/{reviewId}")
    public ResponseEntity<?>deleteReviewById(@PathVariable("reviewId")Long reviewId){
        Review r=reviewService.deleteReviewByReviewId(reviewId);
        if(r!=null){
            return new ResponseEntity<>(r,HttpStatus.OK);
        }
        return new ResponseEntity<>("company invalid or review invalid",HttpStatus.NOT_FOUND);
    }




}
