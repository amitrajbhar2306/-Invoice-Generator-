package com.example.invoice_generator.controller;

import com.example.invoice_generator.dto.CreateInvoiceRequest;
import com.example.invoice_generator.dto.InvoiceDTO;
import com.example.invoice_generator.service.InvoiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/invoices")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class InvoiceController {

    private final InvoiceService invoiceService;

    @PostMapping
    public InvoiceDTO createInvoice(@RequestBody CreateInvoiceRequest request){

        return invoiceService.createInvoice(request);

    }

    @GetMapping("/{id}")
    public InvoiceDTO getInvoice(@PathVariable Long id) {
        return invoiceService.getInvoice(id);
    }

    @GetMapping
    public List<InvoiceDTO> getAllInvoices() {
        return invoiceService.getAllInvoices();
    }

    @DeleteMapping("/{id}")
    public String deleteInvoice(@PathVariable Long id) {

        invoiceService.deleteInvoice(id);

        return "Invoice Deleted Successfully";
    }
}