package org.example.LLD.ParkingLot.fee;

import org.example.LLD.ParkingLot.Ticket;

import java.util.Calendar;

public class FlatRateStrategy implements FeeStrategy{
    private static final double ONE_HOUR_FEE = 10.0;
    @Override
    public double calculateFee(Ticket ticket) {
        long diff = ticket.getExitTimeStamp() - ticket.getEntryTimeStamp();
        long parkedHour = diff / (1000 * 60 * 60) + 1;
        return parkedHour * ONE_HOUR_FEE;
    }
}
