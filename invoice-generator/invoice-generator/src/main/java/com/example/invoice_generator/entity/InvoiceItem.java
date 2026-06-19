package com.example.invoice_generator.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "invoice_items")
public class InvoiceItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String itemName;

    private String hsnCode;

    private Integer quantity;

    private BigDecimal rate;

    private BigDecimal taxPercentage;

    private BigDecimal total;

    @ManyToOne
    @JoinColumn(name = "invoice_id")
    private Invoice invoice;

    public InvoiceItem() {
    }

    public InvoiceItem(Long id, String itemName, String hsnCode, Integer quantity, BigDecimal rate, BigDecimal taxPercentage, BigDecimal total, Invoice invoice) {
        this.id = id;
        this.itemName = itemName;
        this.hsnCode = hsnCode;
        this.quantity = quantity;
        this.rate = rate;
        this.taxPercentage = taxPercentage;
        this.total = total;
        this.invoice = invoice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getHsnCode() {
        return hsnCode;
    }

    public void setHsnCode(String hsnCode) {
        this.hsnCode = hsnCode;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public BigDecimal getTaxPercentage() {
        return taxPercentage;
    }

    public void setTaxPercentage(BigDecimal taxPercentage) {
        this.taxPercentage = taxPercentage;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }
}