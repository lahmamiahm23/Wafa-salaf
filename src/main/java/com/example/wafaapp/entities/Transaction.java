package com.example.wafaapp.entities;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name = "transactions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Transaction extends BaseEntity {
    @Column(length = 20)
    private double amount;
    @Enumerated(EnumType.STRING)
    @Column(name = "transaction_type" , length = 20)
    private TransactionType transactionType;
    @Column(name = "transaction_date" , length = 20)
    private LocalDate transactionDate;
    @ManyToOne
    @JoinColumn(name  = "acc_num", nullable = false)
    private Account accountNo;
    @ManyToOne
    @JoinColumn(name = "receiver's_acc_no")
    private Account receiverAccountNo;

    @Override
    public String toString() {
        return "Transaction  [id = " + super.getId() + "accountNo=" + accountNo + ", receiverAccountNo=" + receiverAccountNo + ", amount=" + amount
                + ", transactionType=" + transactionType + ", transactionDate=" + transactionDate + "]";
    }

    public Transaction(double amount, TransactionType transactionType, LocalDate transactionDate, Account accountNo) {
        super();
        this.amount = amount;
        this.transactionType = transactionType;
        this.transactionDate = transactionDate;
        this.accountNo = accountNo;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Account getReceiverAccountNo() {
        return receiverAccountNo;
    }

    public void setReceiverAccountNo(Account receiverAccountNo) {
        this.receiverAccountNo = receiverAccountNo;
    }

    public Account getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(Account accountNo) {
        this.accountNo = accountNo;
    }
}
