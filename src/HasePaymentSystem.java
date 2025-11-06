import payment.CreditCardPayment;
import payment.PayPalPayment;
import payment.PaymentMethod;

import java.util.Scanner;

public class HasePaymentSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PaymentMethod paymentMethod = null;

        while (true) {
            System.out.println("Bitte wählen Sie eine Zahlungsmethode:");
            System.out.println("1. Kreditkarte");
            System.out.println("2. PayPal");
            System.out.println("0. Beenden");
            System.out.print("Ihre Wahl: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Konsumiert das verbleibende newline-Zeichen

            switch (choice) {
                case 1:
                    // Zahlung mit Kreditkarte
                    System.out.println("Kreditkartenzahlung:");
                    System.out.print("Kartennummer: ");
                    String cardNumber = scanner.nextLine();
                    System.out.print("Karteninhaber: ");
                    String cardHolderName = scanner.nextLine();
                    System.out.print("Ablaufdatum (MM/YY): ");
                    String expiryDate = scanner.nextLine();
                    System.out.print("CVV: ");
                    String cvv = scanner.nextLine();

                    paymentMethod = new CreditCardPayment(cardNumber, cardHolderName, expiryDate, cvv);
                    break;

                case 2:
                    // Zahlung mit PayPal
                    System.out.println("PayPal-Zahlung:");
                    System.out.print("E-Mail: ");
                    String email = scanner.nextLine();
                    System.out.print("Passwort: ");
                    String password = scanner.nextLine();

                    paymentMethod = new PayPalPayment(email, password);
                    break;

                case 0:
                    System.out.println("Programm beendet.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Ungültige Auswahl. Bitte versuchen Sie es erneut.");
                    continue;
            }

            if (paymentMethod != null) {
                System.out.print("Bitte geben Sie den Betrag ein: ");
                double amount = scanner.nextDouble();
                scanner.nextLine(); // Konsumiert das verbleibende newline-Zeichen

                if (paymentMethod.validate()) {
                    paymentMethod.pay(amount);
                } else {
                    System.out.println("Validierung fehlgeschlagen.");
                }
            }

        }
    }
}
