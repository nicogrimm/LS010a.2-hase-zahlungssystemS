package bankingEntity;

import java.util.HashMap;
import java.util.Map;

public class Bank {
    private Map<String, String> creditCardData = new HashMap<>();
    private Map<String, String> paypalData = new HashMap<>();


    public Bank() {
        // Beispielhafte Initialisierung von Daten
        creditCardData.put("1234567812345678", "123");
        creditCardData.put("8765437812357649", "345");
        creditCardData.put("2397638673433245", "657");
        paypalData.put("user@example.com", "password123");
        paypalData.put("mueller@bestmail.com", "geheim");
        paypalData.put("steinber.m@mailsystem.de", "ramz");

    }

    public boolean validateCreditCard(String cardNumber, String cvv) {
        return creditCardData.containsKey(cardNumber) && creditCardData.get(cardNumber).equals(cvv);
    }

    public boolean validatePayPal(String email, String password) {
        return paypalData.containsKey(email) && paypalData.get(email).equals(password);
    }

}
