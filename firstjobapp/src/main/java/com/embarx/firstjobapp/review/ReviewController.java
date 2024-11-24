package com.embarx.firstjobapp.review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/companies/{companyId}")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;
    @GetMapping("/reviews")
    public ResponseEntity<?> getAllReviewsForACompany(@PathVariable("companyId")Long companyId){
        return new ResponseEntity<>(reviewService.getAllReviewsForACompany(companyId), HttpStatus.OK);
    }
    @PostMapping("/reviews")
    public ResponseEntity<?> createReviewsForACompany(@PathVariable("companyId")Long companyId,@RequestBody Review review){
        return new ResponseEntity<>(reviewService.createReviewForACompany(companyId,review), HttpStatus.OK);
    }
    @GetMapping("/reviews/{reviewId}")
    public ResponseEntity<?> getReviewById(@PathVariable("companyId") Long companyId, @PathVariable("reviewId") Long reviewId){
return new ResponseEntity<>(reviewService.getReviewByReviewId(companyId,reviewId), HttpStatus.OK);
    }
    @PutMapping("reviews/{reviewId}")
    public ResponseEntity<?>updateReview(@PathVariable("companyId")Long companyId,@PathVariable("reviewId")Long reviewId,@RequestBody Review review){
        return new ResponseEntity<>(reviewService.updateReviewForACompany(companyId,reviewId,review),HttpStatus.OK);
    }
    @DeleteMapping("reviews/{reviewId}")
    public ResponseEntity<?>deleteReviewById(@PathVariable("companyId")Long companyId,@PathVariable("reviewId")Long reviewId){
        Review r=reviewService.deleteReviewByReviewId(companyId,reviewId);
        if(r!=null){
            return new ResponseEntity<>(r,HttpStatus.OK);
        }
        return new ResponseEntity<>("company invalid or review invalid",HttpStatus.NOT_FOUND);
    }




}
