package com.embarkx.jobms.job.impl;


import com.embarkx.jobms.external.Company;
import com.embarkx.jobms.job.Job;
import com.embarkx.jobms.job.JobRepository;
import com.embarkx.jobms.job.JobService;
import com.embarkx.jobms.job.dto.JobWithCompanyDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class JobServiceImpl implements JobService {
   @Autowired
   JobRepository jobRepository;
public JobWithCompanyDTO jobWithCompanyDTO(Job j){
    RestTemplate restTemplate=new RestTemplate();
    JobWithCompanyDTO jobWithCompanyDTO=new JobWithCompanyDTO();
    Company company= restTemplate.getForObject("http://localhost:8081/companies/"+j.getCompanyId(), Company.class);
    jobWithCompanyDTO.setCompany(company);
    jobWithCompanyDTO.setJob(j);
    return jobWithCompanyDTO;


}
    @Override
    public List<JobWithCompanyDTO> findAll() {
        List<Job>jobs=jobRepository.findAll();
        List<JobWithCompanyDTO>jobWithCompanyDTOs=new ArrayList<JobWithCompanyDTO>();

        for(Job j:jobs){
            jobWithCompanyDTOs.add(jobWithCompanyDTO(j));
        }
        return jobs.stream().map(this::jobWithCompanyDTO).collect(Collectors.toList());
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
