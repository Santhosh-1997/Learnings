package org.example.LLD.ParkingLot;

import org.example.LLD.ParkingLot.vehicles.Vehicle;

public class Ticket {
    private final String ticketId;
    private final Vehicle vehicle;
    private final ParkingSpot parkingSpot;
    private final long entryTimeStamp;
    private long exitTimeStamp;

    public Ticket(String ticketId, Vehicle vehicle, ParkingSpot parkingSpot, long entryTimeStamp) {
        this.ticketId = ticketId;
        this.vehicle = vehicle;
        this.parkingSpot = parkingSpot;
        this.entryTimeStamp = entryTimeStamp;
    }

    public String getTicketId() {
        return ticketId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public long getEntryTimeStamp() {
        return entryTimeStamp;
    }

    public long getExitTimeStamp() {
        return exitTimeStamp;
    }

    public void setExitTimeStamp(long exitTimeStamp) {
        this.exitTimeStamp = exitTimeStamp;
    }
}
