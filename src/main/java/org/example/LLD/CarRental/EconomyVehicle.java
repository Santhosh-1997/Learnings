package org.example.LLD.CarRental;

public class EconomyVehicle extends Vehicle{
    private static final double ECONOMY_FEE = 1;
    private VehicleType type;

    public EconomyVehicle(String number, double rentalPrice) {
        super(number, rentalPrice);
        this.type = VehicleType.ECONOMIC;
    }

    @Override
    public double calculateRentalFee(int days) {
        return days * getBasePrice() * ECONOMY_FEE;
    }
}
