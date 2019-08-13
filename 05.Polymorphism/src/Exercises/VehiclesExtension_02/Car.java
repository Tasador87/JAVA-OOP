package Exercises.VehiclesExtension_02;

import java.text.DecimalFormat;

public class Car extends Vehicle {

    public Car(double fuelQuantity, double fuelConsumption, int tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

    @Override
    public void drive(double distance) {
        if (distance * (getFuelConsumption() + 0.9) <= getFuelQuantity()) {
            double result = getFuelQuantity() - (distance * (getFuelConsumption() + 0.9));
            super.setFuelQuantity(result);
            DecimalFormat format = new DecimalFormat("0.##");
            System.out.println("Car travelled " + format.format(distance) + " km");
        }else {
            System.out.println("Car needs refueling");
        }
    }

    @Override
    public void refuel(double liters) {
        if (getFuelQuantity() + liters <= getTankCapacity()) {
            super.setFuelQuantity(getFuelQuantity() + liters);
        }else {
            System.out.println("Cannot fit fuel in tank");
        }
    }

}