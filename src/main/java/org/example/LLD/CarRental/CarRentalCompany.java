package org.example.LLD.CarRental;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CarRentalCompany {
    private static CarRentalCompany carRentalCompany;
    private List<RentalStore> rentalStores;
    private VechicleFactory vechicleFactory;
    private ReservationManager reservationManager;


    private CarRentalCompany() {
        this.rentalStores = new ArrayList<>();
        this.vechicleFactory = new VechicleFactory();
        this.reservationManager = new ReservationManager();
    }

    public static synchronized CarRentalCompany getCarRentalCompany(){
        if(carRentalCompany == null)
            carRentalCompany = new CarRentalCompany();
        return carRentalCompany;
    }

    public void addStore(RentalStore store){
        this.rentalStores.add(store);
    }

    public RentalStore getStore(int id){
        return this.rentalStores.stream().filter(store -> id == store.getId()).findFirst().orElse(null);
    }

    public List<RentalStore> getRentalStores() {
        return rentalStores;
    }

    public Reservation createReservation(String vehicleRegistration,
                                         int pickupStoreId, int returnStoreId, Date startDate, Date endDate) {
        RentalStore pickupStore = getStore(pickupStoreId);
        RentalStore returnStore = getStore(returnStoreId);
        Vehicle vehicle = (pickupStore != null) ? pickupStore.getVehicle(vehicleRegistration): null;

        if (pickupStore != null && returnStore != null && vehicle != null) {
            return reservationManager.createReservation(vehicle, pickupStore, returnStore, startDate, endDate);
        }
        return null;
    }

    public void startRental(int reservationId) {
        reservationManager.startRental(reservationId);
    }

    public void completeRental(int reservationId) {
        reservationManager.completeRental(reservationId);
    }


}
