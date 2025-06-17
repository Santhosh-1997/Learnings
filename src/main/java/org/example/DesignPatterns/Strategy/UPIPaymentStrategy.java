package org.example.DesignPatterns.Strategy;

public class UPIPaymentStrategy implements PaymentStrategy{
    @Override
    public void processPayment() {
        System.out.println("UPI payment done");
    }
}
