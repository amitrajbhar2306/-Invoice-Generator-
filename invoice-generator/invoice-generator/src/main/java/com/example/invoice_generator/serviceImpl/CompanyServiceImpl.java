package com.example.invoice_generator.serviceImpl;

import com.example.invoice_generator.dto.CompanyDTO;
import com.example.invoice_generator.entity.Company;
import com.example.invoice_generator.repository.CompanyRepository;
import com.example.invoice_generator.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    @Override
    public CompanyDTO saveCompany(CompanyDTO dto) {

//        Company company = Company.builder()
//                .companyName(dto.getCompanyName())
//                .gstNumber(dto.getGstNumber())
//                .address(dto.getAddress())
//                .email(dto.getEmail())
//                .phone(dto.getPhone())
//                .bankName(dto.getBankName())
//                .accountNumber(dto.getAccountNumber())
//                .ifscCode(dto.getIfscCode())
//                .branch(dto.getBranch())
//                .build();

        Company company = new Company();

        company.setCompanyName(dto.getCompanyName());
        company.setGstNumber(dto.getGstNumber());
        company.setAddress(dto.getAddress());
        company.setEmail(dto.getEmail());
        company.setPhone(dto.getPhone());
        company.setBankName(dto.getBankName());
        company.setAccountNumber(dto.getAccountNumber());
        company.setIfscCode(dto.getIfscCode());
        company.setBranch(dto.getBranch());

        company = companyRepository.save(company);

        dto.setId(company.getId());

        return dto;
    }

    @Override
    public CompanyDTO getCompany(Long id) {

        Company company = companyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Company not found"));

        CompanyDTO dto = new CompanyDTO();

        dto.setId(company.getId());
        dto.setCompanyName(company.getCompanyName());
        dto.setGstNumber(company.getGstNumber());
        dto.setAddress(company.getAddress());
        dto.setEmail(company.getEmail());
        dto.setPhone(company.getPhone());
        dto.setBankName(company.getBankName());
        dto.setAccountNumber(company.getAccountNumber());
        dto.setIfscCode(company.getIfscCode());
        dto.setBranch(company.getBranch());

        return dto;
    }

    @Override
    public List<CompanyDTO> getAllCompanies() {

        return companyRepository.findAll()
                .stream()
                .map(company -> {

                    CompanyDTO dto = new CompanyDTO();

                    dto.setId(company.getId());
                    dto.setCompanyName(company.getCompanyName());
                    dto.setGstNumber(company.getGstNumber());
                    dto.setAddress(company.getAddress());
                    dto.setEmail(company.getEmail());
                    dto.setPhone(company.getPhone());
                    dto.setBankName(company.getBankName());
                    dto.setAccountNumber(company.getAccountNumber());
                    dto.setIfscCode(company.getIfscCode());
                    dto.setBranch(company.getBranch());

                    return dto;

                }).collect(Collectors.toList());

    }
}