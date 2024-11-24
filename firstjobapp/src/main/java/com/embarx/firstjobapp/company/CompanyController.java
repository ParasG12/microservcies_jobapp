package com.embarx.firstjobapp.company;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {
    @Autowired
    CompanyService companyService;
    @GetMapping("/")
    public ResponseEntity<List<Company>> getAllCompanies(){
        return new ResponseEntity<>(companyService.getAllCompany(),HttpStatus.OK);
    }
    @RequestMapping("/{id}")
    public ResponseEntity<?>updateCompany(@PathVariable("id")Long id, @RequestBody Company company){
        companyService.updateCompany(id, company);
        return new ResponseEntity<>("companyUpdatedSuccess", HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> addCompany(@RequestBody Company company){
        Company c=companyService.addCompany(company);
        return new ResponseEntity<>(c, HttpStatus.CREATED);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteCompany(@PathVariable("id") Long id){
        companyService.deleteCompany(id);
        return new ResponseEntity<>("company deleted success",HttpStatus.OK);
    }
    @GetMapping("{id}")
            public ResponseEntity<?>getCompanyById(@PathVariable("id") Long id){
        Company c=companyService.getCompanyById(id);
        if(c!=null)return new ResponseEntity<>(c, HttpStatus.OK);
        return new ResponseEntity<>("company not found",HttpStatus.NOT_FOUND);

    }

}
