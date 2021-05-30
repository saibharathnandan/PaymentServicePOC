package com.pps.model;

import javax.validation.constraints.Size;
import java.io.Serializable;

public class Payment  {

    private String transactionId;

    @Size(min =1,max = 30)
    private String payerName;

    private String payeeName;

    private String valueDate;

    private String amount;

    private String currency;

    private String payerCountryCode;

    private String payeeCountryCode;

    private String payerBank;

    private String payeeBank;

    private String paymentInstruction;

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getPayerName() {
        return payerName;
    }

    public void setPayerName(String payerName) {
        this.payerName = payerName;
    }

    public String getPayeeName() {
        return payeeName;
    }

    public void setPayeeName(String payeeName) {
        this.payeeName = payeeName;
    }

    public String getValueDate() {
        return valueDate;
    }

    public void setValueDate(String valueDate) {
        this.valueDate = valueDate;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getPayerCountryCode() {
        return payerCountryCode;
    }

    public void setPayerCountryCode(String payerCountryCode) {
        this.payerCountryCode = payerCountryCode;
    }

    public String getPayeeCountryCode() {
        return payeeCountryCode;
    }

    public void setPayeeCountryCode(String payeeCountryCode) {
        this.payeeCountryCode = payeeCountryCode;
    }

    public String getPayerBank() {
        return payerBank;
    }

    public void setPayerBank(String payerBank) {
        this.payerBank = payerBank;
    }

    public String getPayeeBank() {
        return payeeBank;
    }

    public void setPayeeBank(String payeeBank) {
        this.payeeBank = payeeBank;
    }

    public String getPaymentInstruction() {
        return paymentInstruction;
    }

    public void setPaymentInstruction(String paymentInstruction) {
        this.paymentInstruction = paymentInstruction;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "transactionId='" + transactionId + '\'' +
                ", payerName='" + payerName + '\'' +
                ", payeeName='" + payeeName + '\'' +
                ", valueDate='" + valueDate + '\'' +
                ", amount='" + amount + '\'' +
                ", currency='" + currency + '\'' +
                ", payerCountryCode='" + payerCountryCode + '\'' +
                ", payeeCountryCode='" + payeeCountryCode + '\'' +
                ", payerBank='" + payerBank + '\'' +
                ", payeeBank='" + payeeBank + '\'' +
                ", paymentInstruction='" + paymentInstruction + '\'' +
                '}';
    }
}
