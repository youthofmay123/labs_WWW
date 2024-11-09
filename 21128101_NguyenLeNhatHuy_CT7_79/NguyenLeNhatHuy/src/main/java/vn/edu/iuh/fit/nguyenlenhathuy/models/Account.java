package vn.edu.iuh.fit.nguyenlenhathuy.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Account")
public class Account {
    @Id
    @Column(name = "account_number", length = 10, nullable = false)
    private String accountNumber;
    @Column(name = "owner_name", length = 155)
    private String owner_name;
    @Column(name = "card_number")
    private String cardNumber;
    @Column(name = "owner_address")
    private String ownerAddress;
    @Column(name = "amount")
    private double amount;

    public Account(String accountNumber, String owner_name, String cardNumber, String ownerAddress, double amount) {
        this.accountNumber = accountNumber;
        this.owner_name = owner_name;
        this.cardNumber = cardNumber;
        this.ownerAddress = ownerAddress;
        this.amount = amount;
    }

    public Account() {
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getOwner_name() {
        return owner_name;
    }

    public void setOwner_name(String owner_name) {
        this.owner_name = owner_name;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getOwnerAddress() {
        return ownerAddress;
    }

    public void setOwnerAddress(String ownerAddress) {
        this.ownerAddress = ownerAddress;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber='" + accountNumber + '\'' +
                ", owner_name='" + owner_name + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", ownerAddress='" + ownerAddress + '\'' +
                ", amount=" + amount +
                '}';
    }
}
