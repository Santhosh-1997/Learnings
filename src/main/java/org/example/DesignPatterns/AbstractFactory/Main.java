package org.example.DesignPatterns.AbstractFactory;

public class Main {
    public static void main(String[] args) {
        VehicleFactory vehicleFactory = new CarFactory();
        Vehicle vehicle = vehicleFactory.createVehicle();
        vehicle.start();
        vehicle.stop();

    }
}
