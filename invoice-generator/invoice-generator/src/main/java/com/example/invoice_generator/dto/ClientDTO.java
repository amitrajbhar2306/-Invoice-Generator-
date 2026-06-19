package com.example.invoice_generator.dto;

public class ClientDTO {

    private String clientName;

    private String clientGST;

    private String clientAddress;

    private String clientEmail;

    private String clientPhone;

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
}