package org.example.LLD.CarRental;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        CarRentalCompany rentalCompany = CarRentalCompany.getCarRentalCompany();
        RentalStore store1 = new RentalStore(1, "store1", new Location("city1", "lat1", "lat2"));
        RentalStore store2 = new RentalStore(2, "store2", new Location("city2", "lat2", "long2"));

        rentalCompany.addStore(store1);
        rentalCompany.addStore(store2);


        Vehicle economycar = VechicleFactory.createVehicle("1234", 1000, VehicleType.ECONOMIC);
        store1.addVehicle(economycar);

        Reservation reservation1 = rentalCompany.createReservation(economycar.getNumber(), store1.getId(), store2.getId(), new Date(), new Date());
        rentalCompany.startRental(reservation1.getId());
        rentalCompany.completeRental(reservation1.getId());



    }
}
