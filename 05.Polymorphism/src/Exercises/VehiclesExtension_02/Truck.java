package Exercises.VehiclesExtension_02;

import java.text.DecimalFormat;

public class Truck extends Vehicle {

    public Truck(double fuelQuantity, double fuelConsumption, int tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

    @Override
    public void drive(double distance) {
        if (distance * (getFuelConsumption() + 1.6) <= getFuelQuantity()) {
            double result = getFuelQuantity() - (distance * (getFuelConsumption() + 1.6));
            super.setFuelQuantity(result);
            DecimalFormat format = new DecimalFormat("0.##");
            System.out.println("Truck travelled " + format.format(distance) + " km");
        }else {
            System.out.println("Truck needs refueling");
        }
    }

    @Override
    public void refuel(double liters) {
        if (getFuelQuantity() + (liters * 0.95) <= getTankCapacity()) {
            super.setFuelQuantity(getFuelQuantity() + (liters * 0.95));
        }else {
            System.out.println("Cannot fit fuel in tank");
        }
    }
}
