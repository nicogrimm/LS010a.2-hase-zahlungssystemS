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
                    paymentMethod = new CreditCardPayment();
                    break;

                case 2:
                    paymentMethod = new PayPalPayment();
                    break;

                case 0:
                    System.out.println("Programm beendet.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Ungültige Auswahl. Bitte versuchen Sie es erneut.");
                    continue;
            }

            paymentMethod.einlesen(scanner);

            betragEingabe(paymentMethod, scanner);
        }
    }

    private static void betragEingabe(PaymentMethod paymentMethod, Scanner scanner) {
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
