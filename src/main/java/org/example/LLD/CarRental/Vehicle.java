package org.example.LLD.CarRental;

public abstract class Vehicle {
    private String number;
    private VehicleStatus vehicleStatus;
    private double basePrice;


    public Vehicle(String number, double basePrice) {
        this.number = number;
        this.basePrice = basePrice;
        this.vehicleStatus = VehicleStatus.AVAILABLE;
    }

    public abstract double calculateRentalFee(int days);

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public VehicleStatus getVehicleStatus() {
        return vehicleStatus;
    }

    public void setVehicleStatus(VehicleStatus vehicleStatus) {
        this.vehicleStatus = vehicleStatus;
    }

    public enum VehicleStatus{
        AVAILABLE, BOOKED, NOT_AVAILABLE, RENTED, RESERVED
    }
}