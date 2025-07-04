package org.example.LLD.CarRental;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class RentalStore {
    private int id;
    private String name;
    private Location location;

    private Map<String, Vehicle> vehicleMap = new HashMap<>();

    public RentalStore(int id, String name, Location location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }

    public void addVehicle(Vehicle vehicle){
        vehicleMap.put(vehicle.getNumber(), vehicle);
    }

    public List<Vehicle> getAvailableVehicles(){
        return this.vehicleMap.values().stream().filter(vehicle -> Vehicle.VehicleStatus.AVAILABLE.equals(vehicle.getVehicleStatus())).collect(Collectors.toList());
    }

    public boolean isVehicleAvailable(String number){
        return Optional.ofNullable(vehicleMap.get(number))
                .map(vehicle -> Vehicle.VehicleStatus.AVAILABLE == vehicle.getVehicleStatus())
                .orElse(false);
    }

    public Vehicle getVehicle(String number){
        return vehicleMap.get(number);
    }

    public int getId() {
        return id;
    }
}
