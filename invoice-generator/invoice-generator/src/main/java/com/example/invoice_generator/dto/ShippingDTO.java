package com.example.invoice_generator.dto;

public class ShippingDTO {

    private String shippingPort;

    private String deliveryTerms;

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
}