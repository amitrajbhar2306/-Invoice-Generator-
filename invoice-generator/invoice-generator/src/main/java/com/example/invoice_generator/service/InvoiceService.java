package com.example.invoice_generator.service;

import com.example.invoice_generator.dto.CreateInvoiceRequest;
import com.example.invoice_generator.dto.InvoiceDTO;

import java.util.List;

public interface InvoiceService {

    InvoiceDTO createInvoice(CreateInvoiceRequest request);

    InvoiceDTO getInvoice(Long id);

    List<InvoiceDTO> getAllInvoices();

    void deleteInvoice(Long id);

}
