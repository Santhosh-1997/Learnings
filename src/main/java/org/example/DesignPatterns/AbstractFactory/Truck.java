package org.example.DesignPatterns.AbstractFactory;

public class Truck implements Vehicle{
    @Override
    public void start() {
        System.out.println("Started Truck");
    }

    @Override
    public void stop() {
        System.out.println("Stopped Truck");
    }
}
