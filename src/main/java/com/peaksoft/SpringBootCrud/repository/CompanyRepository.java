package com.peaksoft.SpringBootCrud.repository;

import com.peaksoft.SpringBootCrud.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
}