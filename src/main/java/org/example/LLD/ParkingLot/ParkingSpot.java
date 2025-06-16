package org.example.LLD.ParkingLot;

import org.example.LLD.ParkingLot.vehicles.Vehicle;
import org.example.LLD.ParkingLot.vehicles.VehicleType;

public class ParkingSpot {
    private final int spotNumber;
    private boolean isOccupied;
    private VehicleType vehicleType;
    private Vehicle vehicle;

    public ParkingSpot(int spotNumber, VehicleType vehicleType) {
        this.spotNumber = spotNumber;
        this.vehicleType = vehicleType;
        isOccupied = false;
    }
    public boolean isAvailable(){
        return !isOccupied;
    }

    public synchronized boolean park(Vehicle vehicle){
        if(isOccupied)  return false;
        if(vehicle.getVehicleType() != vehicleType)     return false;
        isOccupied = true;
        this.vehicle = vehicle;
        return true;
    }

    public void unPark(){
        isOccupied = false;
        this.vehicle = null;

    }

    public int getSpotNumber() {
        return spotNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}
