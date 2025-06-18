package org.example.DesignPatterns.Factory;

public class VehicleFactory {
    public static Vehicle getVehicle(String vehicle){
        switch (vehicle){
            case "Car":
                return new Car();
            case "Bike":
                return new Bike();
            default:
                throw new UnsupportedOperationException("Not supported");
        }
    }
}
