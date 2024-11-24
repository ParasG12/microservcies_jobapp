package com.embarkx.jobms.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class JobController {
    @Autowired
    private JobService jobService;

@GetMapping("/jobs")
    public ResponseEntity<?> findAll() {
return new ResponseEntity<>(jobService.findAll(),HttpStatus.OK);
    }
    @PostMapping("/jobs")
    public ResponseEntity<?> createJob(@RequestBody Job job) {
    jobService.createJob(job);
    return new ResponseEntity<>("Job added succesfully",HttpStatus.CREATED);
    }
    @GetMapping("/jobs/{id}")
    public ResponseEntity<?> getJobById(@PathVariable("id")long id){
   Job j=  jobService.findJobById(id);
   if(j!=null)return new ResponseEntity<>(j,HttpStatus.OK);
   return new ResponseEntity<>(new Job(1L,"testJob","TestJob","2000","2000","loc"), HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/jobs/{id}")
    public ResponseEntity<?> deleteJobById(@PathVariable("id")long id){
   Job job= jobService.deleteJobById(id);
   if(job!=null)return new ResponseEntity<>(job,HttpStatus.OK);
   return new ResponseEntity<>("Job Not Found",HttpStatus.NOT_FOUND);
    }
    @PutMapping("/jobs/{id}")
    public ResponseEntity<?>updateJobById(@PathVariable("id")long id,@RequestBody Job job){
    Job updatedJob=jobService.updateJobById(id,job);
    return new ResponseEntity<>(updatedJob,HttpStatus.OK);
    }


//    @GetMapping("/jobs/{id}")
//
//    @PutMapping("/jobs/{id}")
//    @DeleteMapping ("/jobs/{id}")

}
