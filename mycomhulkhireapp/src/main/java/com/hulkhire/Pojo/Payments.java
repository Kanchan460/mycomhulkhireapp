package com.hulkhire.Pojo;

import java.time.LocalDateTime;

public class Payments {

    private Long id;
    private String payerName;
    private Double amount;
    private String currency;
    private String paymentMode; // UPI, Card, etc.
    private String status; // PENDING, SUCCESS, FAILED
    private LocalDateTime timestamp;
    private String receiver;
    private String referenceId;
    private String remarks;
    private String location;

    public Payments() {}

    public Payments(Long id, String payerName, Double amount, String currency, String paymentMode,
                    String status, LocalDateTime timestamp, String receiver, String referenceId,
                    String remarks, String location) {
        this.id = id;
        this.payerName = payerName;
        this.amount = amount;
        this.currency = currency;
        this.paymentMode = paymentMode;
        this.status = status;
        this.timestamp = timestamp;
        this.receiver = receiver;
        this.referenceId = referenceId;
        this.remarks = remarks;
        this.location = location;
    }

    // Getters & Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPayerName() {
        return payerName;
    }

    public void setPayerName(String payerName) {
        this.payerName = payerName;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
