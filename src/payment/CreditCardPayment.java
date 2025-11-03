package payment;

import bankingEntity.*;

public class CreditCardPayment {
    private String cardNumber;
    private String cardHolderName;
    private String expiryDate;
    private String cvv;

    public CreditCardPayment(String cardNumber, String cardHolderName, String expiryDate, String cvv) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
    }

    public void pay(double amount) {
        System.out.println("Bezahlung von " + amount + " mit Kreditkarte erfolgreich.");
    }

    public boolean validate(Bank bank) {
        return bank.validateCreditCard(cardNumber, cvv);
    }
}
