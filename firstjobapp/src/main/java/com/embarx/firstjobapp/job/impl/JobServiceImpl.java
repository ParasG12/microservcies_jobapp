package com.embarx.firstjobapp.job.impl;

import com.embarx.firstjobapp.job.Job;
import com.embarx.firstjobapp.job.JobRepository;
import com.embarx.firstjobapp.job.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class JobServiceImpl implements JobService {
   @Autowired
    JobRepository jobRepository;

    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public void createJob(Job job) {
     jobRepository.save(job);


    }

    @Override
    public Job findJobById(long id) {
     return  jobRepository.findById(id).orElse(null);

    }

    @Override
    public Job deleteJobById(long id) {

     Job j=jobRepository.findById(id).orElse(null);
     jobRepository.delete(jobRepository.findById(id).get());
     return  j;

    }

    @Override
    public Job updateJobById(long id, Job job) {
        Job j=null;
        j=jobRepository.findById(id).orElse(null);
        if(j!=null) {
            j.setMinSalary(job.getMinSalary());
            j.setMaxSalary(job.getMaxSalary());
            j.setTitle(job.getTitle());
            j.setDescription(job.getDescription());
            j.setLocation(job.getLocation());
            j = jobRepository.save(j);
        }
        return j;

    }
}
