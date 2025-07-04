package org.example.LLD.CarRental;

public class VechicleFactory {
    public static Vehicle createVehicle(String number, double rentalPrice, VehicleType type){
        if(type.equals(VehicleType.ECONOMIC)){
            return new EconomyVehicle(number,  rentalPrice);
        }else if(type.equals(VehicleType.LUXURY)){
            return new LuxuryVehicle(number, rentalPrice);
        }else{
            return null;
        }
    }
}
