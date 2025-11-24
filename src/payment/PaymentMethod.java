package payment;

import java.util.Scanner;

public interface PaymentMethod {
    void einlesen(Scanner scanner);
    void pay(double amount);
    boolean validate();
}
