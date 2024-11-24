package com.embarx.firstjobapp.job;

import java.util.List;

public interface JobService {
   List<Job> findAll();
    void createJob(Job job);


    Job findJobById(long id);

    Job deleteJobById(long id);

    Job updateJobById(long id, Job job);
}
