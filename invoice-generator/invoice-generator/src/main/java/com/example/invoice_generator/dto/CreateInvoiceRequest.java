package com.example.invoice_generator.dto;

import java.time.LocalDate;
import java.util.List;

public class CreateInvoiceRequest {

    private CompanyDTO company;

    private ClientDTO client;

    private ShippingDTO shipping;

    private LocalDate invoiceDate;

    private List<InvoiceItemDTO> items;

    public CompanyDTO getCompany() {
        return company;
    }

    public void setCompany(CompanyDTO company) {
        this.company = company;
    }

    public ClientDTO getClient() {
        return client;
    }

    public void setClient(ClientDTO client) {
        this.client = client;
    }

    public ShippingDTO getShipping() {
        return shipping;
    }

    public void setShipping(ShippingDTO shipping) {
        this.shipping = shipping;
    }

    public LocalDate getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(LocalDate invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public List<InvoiceItemDTO> getItems() {
        return items;
    }

    public void setItems(List<InvoiceItemDTO> items) {
        this.items = items;
    }
}