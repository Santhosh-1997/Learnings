package org.example.LLD.ParkingLot.fee;

import org.example.LLD.ParkingLot.Ticket;

public interface FeeStrategy {
    double calculateFee(Ticket ticket);
}
