package com.embarkx.jobms.job.dto;

import com.embarkx.jobms.external.Company;
import com.embarkx.jobms.job.Job;

public class JobWithCompanyDTO {
    private Job job;
    private Company company;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }
}
