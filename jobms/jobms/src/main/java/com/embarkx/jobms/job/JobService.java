package com.embarkx.jobms.job;

import com.embarkx.jobms.job.dto.JobWithCompanyDTO;

import java.util.List;

public interface JobService {
   List<JobWithCompanyDTO> findAll();
    void createJob(Job job);


    Job findJobById(long id);

    Job deleteJobById(long id);

    Job updateJobById(long id, Job job);
}
