package org.example.LLD.ParkingLot.fee;

import org.example.LLD.ParkingLot.Ticket;
import org.example.LLD.ParkingLot.vehicles.VehicleType;

import java.util.HashMap;
import java.util.Map;

public class VehicleStrategy implements FeeStrategy{
    private final Map<VehicleType, Double> hourlyRates = Map.of(
            VehicleType.CAR, 20.0,
            VehicleType.BIKE, 10.0,
            VehicleType.TRUCK, 30.0
    );
    @Override
    public double calculateFee(Ticket ticket) {
        long diff = ticket.getExitTimeStamp() - ticket.getEntryTimeStamp();
        long parkedHour = diff / (1000 * 60 * 60) + 1;
        return hourlyRates.get(ticket.getVehicle().getVehicleType()) * parkedHour;
    }
}
