package com.example.invoice_generator.config;

import com.example.invoice_generator.repository.InvoiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InvoiceNumberGenerator {

    private final InvoiceRepository invoiceRepository;

    public String generateInvoiceNumber() {

        long count = invoiceRepository.count() + 1;

        return String.format("INV-%05d", count);
    }
}