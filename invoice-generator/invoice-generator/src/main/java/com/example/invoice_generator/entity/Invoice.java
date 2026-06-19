package com.example.invoice_generator.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "invoices")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String invoiceNumber;

    private LocalDate invoiceDate;

    private String clientName;

    private String clientGST;

    private String clientAddress;

    private String clientEmail;

    private String clientPhone;

    private String shippingPort;

    private String deliveryTerms;

    private BigDecimal subTotal;

    private BigDecimal cgst;

    private BigDecimal sgst;

    private BigDecimal grandTotal;

    private String amountInWords;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @OneToMany(mappedBy = "invoice",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<InvoiceItem> items;

    public Invoice() {
    }

    public Invoice(Long id, String invoiceNumber, LocalDate invoiceDate, String clientName, String clientGST, String clientAddress, String clientEmail, String clientPhone, String shippingPort, String deliveryTerms, BigDecimal subTotal, BigDecimal cgst, BigDecimal sgst, BigDecimal grandTotal, String amountInWords, Company company, List<InvoiceItem> items) {
        this.id = id;
        this.invoiceNumber = invoiceNumber;
        this.invoiceDate = invoiceDate;
        this.clientName = clientName;
        this.clientGST = clientGST;
        this.clientAddress = clientAddress;
        this.clientEmail = clientEmail;
        this.clientPhone = clientPhone;
        this.shippingPort = shippingPort;
        this.deliveryTerms = deliveryTerms;
        this.subTotal = subTotal;
        this.cgst = cgst;
        this.sgst = sgst;
        this.grandTotal = grandTotal;
        this.amountInWords = amountInWords;
        this.company = company;
        this.items = items;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public LocalDate getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(LocalDate invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientGST() {
        return clientGST;
    }

    public void setClientGST(String clientGST) {
        this.clientGST = clientGST;
    }

    public String getClientAddress() {
        return clientAddress;
    }

    public void setClientAddress(String clientAddress) {
        this.clientAddress = clientAddress;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    public String getClientPhone() {
        return clientPhone;
    }

    public void setClientPhone(String clientPhone) {
        this.clientPhone = clientPhone;
    }

    public String getShippingPort() {
        return shippingPort;
    }

    public void setShippingPort(String shippingPort) {
        this.shippingPort = shippingPort;
    }

    public String getDeliveryTerms() {
        return deliveryTerms;
    }

    public void setDeliveryTerms(String deliveryTerms) {
        this.deliveryTerms = deliveryTerms;
    }

    public BigDecimal getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(BigDecimal subTotal) {
        this.subTotal = subTotal;
    }

    public BigDecimal getCgst() {
        return cgst;
    }

    public void setCgst(BigDecimal cgst) {
        this.cgst = cgst;
    }

    public BigDecimal getSgst() {
        return sgst;
    }

    public void setSgst(BigDecimal sgst) {
        this.sgst = sgst;
    }

    public BigDecimal getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(BigDecimal grandTotal) {
        this.grandTotal = grandTotal;
    }

    public String getAmountInWords() {
        return amountInWords;
    }

    public void setAmountInWords(String amountInWords) {
        this.amountInWords = amountInWords;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<InvoiceItem> getItems() {
        return items;
    }

    public void setItems(List<InvoiceItem> items) {
        this.items = items;
    }
}