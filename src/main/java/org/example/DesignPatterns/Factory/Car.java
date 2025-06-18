package org.example.DesignPatterns.Factory;

public class Car implements Vehicle{
    @Override
    public void start() {
        System.out.println("Started Car");
    }

    @Override
    public void stop() {
        System.out.println("Stopped Car");
    }
}
