import bankingEntity.Bank;
import payment.CreditCardPayment;
import payment.PayPalPayment;

import java.util.Scanner;

public class HasePaymentSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PayPalPayment payPaalpayment = null;
        CreditCardPayment creditCardPayment = null;
        Bank bank = new Bank();

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

                    creditCardPayment = new CreditCardPayment(cardNumber, cardHolderName, expiryDate, cvv);

                    if (creditCardPayment != null) {
                        System.out.print("Bitte geben Sie den Betrag ein: ");
                        double amount = scanner.nextDouble();
                        scanner.nextLine(); // Konsumiert das verbleibende newline-Zeichen

                        if (creditCardPayment.validate(bank)) {
                            creditCardPayment.pay(amount);
                        } else {
                            System.out.println("Validierung fehlgeschlagen.");
                        }
                    }
                    break;

                case 2:
                    // Zahlung mit PayPal
                    System.out.println("PayPal-Zahlung:");
                    System.out.print("E-Mail: ");
                    String email = scanner.nextLine();
                    System.out.print("Passwort: ");
                    String password = scanner.nextLine();

                    payPaalpayment = new PayPalPayment(email, password);

                    if (payPaalpayment != null) {
                        System.out.print("Bitte geben Sie den Betrag ein: ");
                        double amount = scanner.nextDouble();
                        scanner.nextLine(); // Konsumiert das verbleibende newline-Zeichen

                        if (payPaalpayment.validate(bank)) {
                            payPaalpayment.pay(amount);
                        } else {
                            System.out.println("Validierung fehlgeschlagen.");
                        }
                    }
                    break;

                case 0:
                    System.out.println("Programm beendet.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Ungültige Auswahl. Bitte versuchen Sie es erneut.");
                    continue;
            }

        }
    }
}
