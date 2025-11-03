package payment;

import bankingEntity.*;

public class PayPalPayment {
    private String email;
    private String password;

    public PayPalPayment(String email, String password) {
        this.email = email;
        this.password = password;
    }


    public void pay(double amount) {
        System.out.println("Bezahlung von " + amount + " mit PayPal erfolgreich.");
    }

    public boolean validate(Bank bank) {
        return bank.validatePayPal(email, password);
    }
}