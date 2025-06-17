package org.example.DesignPatterns.Strategy;

public class Main {
    public static void main(String[] args) {
        PaymentProcessor processor = new PaymentProcessor(new CreditCardPaymentStrategy());
        processor.makePayment();
    }
}
