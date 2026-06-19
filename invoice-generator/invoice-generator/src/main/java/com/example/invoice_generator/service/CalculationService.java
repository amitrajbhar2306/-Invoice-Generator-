package com.example.invoice_generator.service;

import com.example.invoice_generator.entity.Invoice;

public interface CalculationService {

    void calculateInvoice(Invoice invoice);

}