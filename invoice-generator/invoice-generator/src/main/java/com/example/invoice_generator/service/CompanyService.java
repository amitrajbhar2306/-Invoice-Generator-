package com.example.invoice_generator.service;

import com.example.invoice_generator.dto.CompanyDTO;

import java.util.List;

public interface CompanyService {

    CompanyDTO saveCompany(CompanyDTO companyDTO);

    CompanyDTO getCompany(Long id);

    List<CompanyDTO> getAllCompanies();

}
