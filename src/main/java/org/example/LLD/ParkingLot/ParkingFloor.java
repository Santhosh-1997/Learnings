package org.example.LLD.ParkingLot;

import org.example.LLD.ParkingLot.vehicles.Vehicle;

import java.util.List;
import java.util.Optional;

public class ParkingFloor {
    private final int floorNumber;
    private final List<ParkingSpot> parkingSpots;

    public ParkingFloor(int floorNumber, List<ParkingSpot> parkingSpots) {
        this.floorNumber = floorNumber;
        this.parkingSpots = parkingSpots;
    }

    public Optional<ParkingSpot> getAvailableSpot(Vehicle vehicle){
        return parkingSpots.stream().filter(spot -> spot.getVehicleType().equals(vehicle.getVehicleType())).findFirst();
    }
}
