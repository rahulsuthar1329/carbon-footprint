package models;

public class Payment {
    private String cardType;
    private double amount;
    private String cardHolderName;
    private String cardNumber;

    public Payment(String cardType, double amount, String cardHolderName, String cardNumber) {
        this.cardType = cardType;
        this.amount = amount;
        this.cardHolderName = cardHolderName;
        this.cardNumber = cardNumber;
    }

    public String getCardType() {
        return cardType;
    }

    public double getAmount() {
        return amount;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public String getCardNumber() {
        return cardNumber;
    }
}