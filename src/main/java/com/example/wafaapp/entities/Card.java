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
import lombok.ToString;

@Entity
@Table(name = "cards")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "account" , callSuper = true)
public class Card extends BaseEntity {
    @Enumerated(EnumType.STRING)
    @Column(name = "card_type")
    private CardType cardType;

    public CardNetwork getCardNetwork() {
        return cardNetwork;
    }

    public void setCardNetwork(CardNetwork cardNetwork) {
        this.cardNetwork = cardNetwork;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public int getCVV() {
        return CVV;
    }

    public void setCVV(int CVV) {
        this.CVV = CVV;
    }

    public double getMaxTransactionAmount() {
        return maxTransactionAmount;
    }

    public void setMaxTransactionAmount(double maxTransactionAmount) {
        this.maxTransactionAmount = maxTransactionAmount;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    @Enumerated(EnumType.STRING)
    @Column(name="card_network")
    private CardNetwork cardNetwork;
    @Column(name= "expiry_date")
    private LocalDate expiryDate;
    @Column(name= "creation_date")
    private LocalDate creationDate;

    @Column
    private int CVV;
    @Column(name = "max_transaction_amount")
    private double maxTransactionAmount;

    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    public Card(String cardType, String cardNetwork) {
        super();
        this.cardNetwork = CardNetwork.valueOf(cardNetwork);
        this.cardType = CardType.valueOf(cardNetwork);
        this.creationDate = LocalDate.now();
        this.expiryDate = LocalDate.of(creationDate.getYear()+10, creationDate.getMonth(),creationDate.getDayOfMonth());

    }
}
