package com.example.invoice_generator.controller;

import com.example.invoice_generator.dto.CompanyDTO;
import com.example.invoice_generator.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/company")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class CompanyController {

    private final CompanyService companyService;

    @PostMapping
    public CompanyDTO saveCompany(@RequestBody CompanyDTO dto) {
        return companyService.saveCompany(dto);
    }

    @GetMapping("/{id}")
    public CompanyDTO getCompany(@PathVariable Long id) {
        return companyService.getCompany(id);
    }

    @GetMapping
    public List<CompanyDTO> getAllCompanies() {
        return companyService.getAllCompanies();
    }
}