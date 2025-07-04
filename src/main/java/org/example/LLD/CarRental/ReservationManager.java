package org.example.LLD.CarRental;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ReservationManager {
    private Map<Integer, Reservation> reservations;
    private static int id = 1;

    public ReservationManager() {
        this.reservations = new HashMap<>();
    }

    public Reservation createReservation(Vehicle vehicle, RentalStore pickupStore, RentalStore dropStore, Date startDate, Date endDate){
        Reservation reservation = new Reservation(id++, vehicle, pickupStore, dropStore, startDate, endDate);
        reservations.put(reservation.getId(), reservation);
        return reservation;
    }

    public void confirmReservation(int id){
        Reservation reservation = reservations.get(id);
        reservation.confirmReservation();
    }

    public void startRental(int id){
        reservations.get(id).startRental();
    }

    public void completeRental(int id){
        reservations.get(id).completeRental();
    }
}
