package Exercises.VehiclesExtension_02;

import java.text.DecimalFormat;

public class Bus extends Vehicle {

    public Bus(double fuelQuantity, double fuelConsumption, int tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

    @Override
    public void drive(double distance) {
        if (distance * (getFuelConsumption() + 1.4) <= getFuelQuantity()) {
            double result = getFuelQuantity() - (distance * (getFuelConsumption() + 1.4));
            super.setFuelQuantity(result);
            DecimalFormat format = new DecimalFormat("0.##");
            System.out.println("Bus travelled " + format.format(distance) + " km");
        } else {
            System.out.println("Bus needs refueling");
        }
    }

    public void driveEmpty(double distance) {
        if (distance * this.getFuelConsumption() <= this.getFuelQuantity()) {
            double result = this.getFuelQuantity() - (distance * this.getFuelConsumption());
            super.setFuelQuantity(result);
            DecimalFormat format = new DecimalFormat("0.##");
            System.out.println("Bus travelled " + format.format(distance) + " km");
        } else {
            System.out.println("Bus needs refueling");
        }
    }

    @Override
    public void refuel(double liters) {
        if (getFuelQuantity() + liters <= getTankCapacity()) {
            super.setFuelQuantity(getFuelQuantity() + liters);
        } else {
            System.out.println("Cannot fit fuel in tank");
        }
    }
}
