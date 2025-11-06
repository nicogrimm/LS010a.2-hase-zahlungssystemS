package payment;

import java.util.HashMap;
import java.util.Map;

public class CreditCardPayment implements PaymentMethod {
    public static Map<String, String> validCardData = new HashMap<>();

    static {
        validCardData.put("1234567812345678", "123");
        validCardData.put("8765437812357649", "345");
        validCardData.put("2397638673433245", "657");
    }

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

    public boolean validate() {
        return validCardData.containsKey(cardNumber) && validCardData.get(cardNumber).equals(cvv);
    }
}
