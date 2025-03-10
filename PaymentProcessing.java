import models.*;

public class PaymentProcessing {
    public void processPayment(Payment payment) {
        validatePaymentMethod(payment.getCardType());
        printTransactionDetails(payment);
    }

    private void validatePaymentMethod(String cardType) {
        switch (cardType) {
            case "Credit":
                System.out.println("Processing Credit Card payment of $" + cardType);
                break;
            case "Debit":
                System.out.println("Processing Debit Card payment of $" + cardType);
                break;
            default:
                System.out.println("Unknown Payment Method");
                break;
        }
    }

    private void printTransactionDetails(Payment payment) {
        if (payment.getAmount() > 1000) {
            System.out.println("High-value transaction alert!");
        }
        System.out.println("Payment Done for " + payment.getCardHolderName() + " (Card Ending: "
                + getCardLastFourDigits(payment.getCardNumber()) + ")");
    }

    private String getCardLastFourDigits(String cardNumber) {
        return cardNumber.substring(cardNumber.length() - 4);
    }
}