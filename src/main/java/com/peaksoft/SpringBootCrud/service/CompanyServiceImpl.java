package com.peaksoft.SpringBootCrud.service;

import com.peaksoft.SpringBootCrud.model.Company;
import com.peaksoft.SpringBootCrud.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService{


    private final CompanyRepository companyRepository;

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public void saveCompany(Company company) {
        this.companyRepository.save(company);
    }

    @Override
    public Company getCompanyById(long id) {
        Optional<Company> optional = companyRepository.findById(id);
        Company company = null;
        if (optional.isPresent()) {
            company = optional.get();
        } else {
            throw new RuntimeException(" Company not found for id :: " + id);
        }
        return company;
    }

    @Override
    public void deleteCompanyById(long id) {
        this.companyRepository.deleteById(id);

    }
}


