package org.example.LLD.ParkingLot;

import org.example.LLD.ParkingLot.vehicles.Vehicle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public class ParkingLot {
    private static volatile ParkingLot instance;
    private final List<ParkingFloor> floors;
    private final Map<String, Ticket> activeTickets = new HashMap<>();
    private ParkingLot() {
        this.floors = new ArrayList<>();
    }

    public ParkingLot getInstance(){
        if(instance == null){
            synchronized (ParkingLot.class){
                if(instance == null)
                    instance = new ParkingLot();
            }
        }
        return instance;
    }
    public void addFloor(ParkingFloor floor){
        floors.add(floor);
    }

    public Ticket parkVehicle(Vehicle vehicle) throws Exception{
        for(ParkingFloor floor : floors){
            Optional<ParkingSpot> spot = floor.getAvailableSpot(vehicle);
            if(spot.isPresent()){
                ParkingSpot parkingSpot = spot.get();
                if(parkingSpot.park(vehicle)){
                    String ticketId = UUID.randomUUID().toString();
                    Ticket ticket = new Ticket(ticketId, vehicle, parkingSpot, System.currentTimeMillis());
                    activeTickets.put(ticketId, ticket);
                    return ticket;
                }
            }
        }
        throw new Exception("No Spot available " + vehicle.getVehicleType());
    }

    public void unParkVehicle(String ticketId) throws Exception{
        Ticket ticket = activeTickets.get(ticketId);
        if(ticket == null)
                throw new Exception("Invalid ticket");
        ParkingSpot parkingSpot = ticket.getParkingSpot();
        parkingSpot.unPark();
        ticket.setExitTimeStamp(System.currentTimeMillis());
        activeTickets.remove(ticketId);
    }
}
