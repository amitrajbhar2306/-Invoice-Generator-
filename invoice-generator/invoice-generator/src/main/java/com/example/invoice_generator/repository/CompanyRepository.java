package com.example.invoice_generator.repository;

import com.example.invoice_generator.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
