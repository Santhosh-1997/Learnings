package org.example.DesignPatterns.Factory;

public class Bike implements Vehicle{
    @Override
    public void start() {
        System.out.println("Started Bike");
    }

    @Override
    public void stop() {
        System.out.println("Stopped Bike");
    }
}
