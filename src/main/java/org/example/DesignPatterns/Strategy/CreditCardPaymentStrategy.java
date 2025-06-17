package org.example.DesignPatterns.Strategy;

public class CreditCardPaymentStrategy implements PaymentStrategy{

    @Override
    public void processPayment() {
        System.out.println("Credit card payment done");
    }
}
