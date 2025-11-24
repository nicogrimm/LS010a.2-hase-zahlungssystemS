package payment;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PayPalPayment implements PaymentMethod {
    static public Map<String, String> validAccountData = new HashMap<>();

    static {
        validAccountData.put("user@example.com", "password123");
        validAccountData.put("mueller@bestmail.com", "geheim");
        validAccountData.put("steinber.m@mailsystem.de", "ramz");
    }

    private String email;
    private String password;

    public PayPalPayment() {}

    public PayPalPayment(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public void einlesen(Scanner scanner) {
        System.out.println("PayPal-Zahlung:");
        System.out.print("E-Mail: ");
        this.email = scanner.nextLine();
        System.out.print("Passwort: ");
        this.password = scanner.nextLine();
    }

    @Override
    public void pay(double amount) {
        System.out.println("Bezahlung von " + amount + " mit PayPal erfolgreich.");
    }

    @Override
    public boolean validate() {
        return validAccountData.containsKey(email) && validAccountData.get(email).equals(password);
    }
}