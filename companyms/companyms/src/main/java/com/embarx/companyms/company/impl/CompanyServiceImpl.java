package com.embarx.companyms.company.impl;


import com.embarx.companyms.company.Company;
import com.embarx.companyms.company.CompanyRepository;
import com.embarx.companyms.company.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    CompanyRepository companyRepository;
    @Override
    public List<Company> getAllCompany() {
        return companyRepository.findAll();
    }

    @Override
    public Company getCompanyById(Long id) {
       Company c=companyRepository.findById(id).orElse(null);
       return c;

    }

    @Override
    public Company addCompany(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public Company updateCompany(Long id,Company company) {
        Company company1=companyRepository.findById(id).orElse(null);
        if(company1!=null){
            company1.setName(company.getName());
            company1.setDescription(company.getDescription());


          return   companyRepository.save(company1);

        }
        return null;
    }

    @Override
    public void deleteCompany(Long id) {
        companyRepository.delete(companyRepository.findById(id).get());

    }
}
