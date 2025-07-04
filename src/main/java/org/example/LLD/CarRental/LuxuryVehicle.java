package org.example.LLD.CarRental;

public class LuxuryVehicle extends Vehicle{
    public static double LuxuryFee = 2;
    private VehicleType vehicleType;
    public LuxuryVehicle(String number, double basePrice) {
        super(number, basePrice);
        this.vehicleType = VehicleType.LUXURY;
    }

    @Override
    public double calculateRentalFee(int days) {
        return days * getBasePrice() * LuxuryFee;
    }
}
