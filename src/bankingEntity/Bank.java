package bankingEntity;

import java.util.HashMap;
import java.util.Map;

public class Bank {
    private Map<String, String> creditCardData = new HashMap<>();
    private Map<String, String> paypalData = new HashMap<>();


    public Bank() {
        // Beispielhafte Initialisierung von Daten
        creditCardData.put("1234567812345678", "123");
        paypalData.put("user@example.com", "password123");
    }

    public boolean validateCreditCard(String cardNumber, String cvv) {
        return creditCardData.containsKey(cardNumber) && creditCardData.get(cardNumber).equals(cvv);
    }

    public boolean validatePayPal(String email, String password) {
        return paypalData.containsKey(email) && paypalData.get(email).equals(password);
    }

}
