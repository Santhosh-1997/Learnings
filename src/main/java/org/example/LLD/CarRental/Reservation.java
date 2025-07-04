package org.example.LLD.CarRental;

import java.util.Calendar;
import java.util.Date;

public class Reservation {
    private int id;
    private Vehicle vehicle;
    private RentalStore pickupStore;
    private RentalStore dropStore;
    private Date startDate;
    private Date endDate;
    private double totalAmount;
    private ReservationStatus reservationStatus;

    public void confirmReservation() {
        if (this.reservationStatus == ReservationStatus.PENDING) {
            reservationStatus = ReservationStatus.CONFIRMED;
            vehicle.setVehicleStatus(Vehicle.VehicleStatus.RESERVED);
        }
    }
    public void startRental(){
        this.reservationStatus = ReservationStatus.IN_PROGRESS;
        this.vehicle.setVehicleStatus(Vehicle.VehicleStatus.RENTED);
    }

    public void completeRental(){
        this.reservationStatus = ReservationStatus.COMPLETED;
        this.vehicle.setVehicleStatus(Vehicle.VehicleStatus.AVAILABLE);
    }

    public Reservation(int id, Vehicle vehicle, RentalStore pickupStore, RentalStore dropStore, Date startDate, Date endDate) {
        this.id = id;
        this.vehicle = vehicle;
        this.pickupStore = pickupStore;
        this.dropStore = dropStore;
        this.startDate = startDate;
        this.endDate = endDate;

        long diffInMillies = endDate.getTime() - startDate.getTime();
        int days = (int) (diffInMillies / (1000 * 60 * 60 * 24)) + 1;
        this.totalAmount = vehicle.calculateRentalFee(days);
        this.reservationStatus = ReservationStatus.PENDING;
    }

    public int getId() {
        return id;
    }

    public enum ReservationStatus{
        IN_PROGRESS, COMPLETED, PENDING, CONFIRMED
    }
}

