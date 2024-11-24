package com.embarx.companyms.company;

import java.util.List;

public interface CompanyService {
    List<Company> getAllCompany();
    Company getCompanyById(Long id);
    Company addCompany(Company company);
    Company updateCompany(Long id,Company company);
    void deleteCompany(Long id);


}
