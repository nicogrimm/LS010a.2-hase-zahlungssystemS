package payment;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

public class BitCoinPayment  implements PaymentMethod{
    static public HashSet<String> validBitCoinAdresses = new HashSet<>();

    static {
        validBitCoinAdresses.add("1A1zP1eP5QGefi2DMPTfTL5SLmv7DivfNa");
        validBitCoinAdresses.add("3J98t1WpEZ73CNmYviecrnyiWrnqRhWNLy");
        validBitCoinAdresses.add("bc1qxy2kgdygjrsqtzq2n0yrf2493p83kkfjhx0wlh");
    }

    private String walletAddress;

    public BitCoinPayment() {}

    public BitCoinPayment(String walletAddress) {
        this.walletAddress = walletAddress;
    }

    @Override
    public void einlesen(Scanner scanner) {
        System.out.println("Bitcoin-Zahlung:");
        System.out.print("Wallet-Adress: ");
        this.walletAddress = scanner.nextLine();
    }

    @Override
    public void pay(double amount) {
        System.out.println("Bezahlung von " + amount + " mit Bitcoin erfolgreich.");
    }

    @Override
    public boolean validate() {
        return validBitCoinAdresses.contains(this.walletAddress);
    }
}
