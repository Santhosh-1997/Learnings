package org.example.DesignPatterns.Factory;

public class Main {
    public static void main(String[] args) {
        Vehicle vehicle = VehicleFactory.getVehicle("Car");
        vehicle.start();
        vehicle.stop();
    }
}
