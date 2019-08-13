package Exercises.VehiclesExtension_02;

public abstract class Vehicle {

    private double fuelQuantity;
    private double fuelConsumption; // liters per km.
    private int tankCapacity;

    public Vehicle(double fuelQuantity, double fuelConsumption, int tankCapacity) {
        this.setFuelQuantity(fuelQuantity);
        this.setFuelConsumption(fuelConsumption);
        this.setTankCapacity(tankCapacity);
    }

    public double getFuelQuantity() {
        return this.fuelQuantity;
    }

    public double getFuelConsumption() {
        return this.fuelConsumption;
    }

    public int getTankCapacity() {
        return tankCapacity;
    }

    public void setFuelQuantity(double fuelQuantity) {
        if (fuelQuantity < 0){
            System.out.println("Fuel must be a positive number");
        }
        this.fuelQuantity = fuelQuantity;
    }

    public void setTankCapacity(int tankCapacity) {
        if (tankCapacity < 0){
            System.out.println("Fuel must be a positive number");
        }
        this.tankCapacity = tankCapacity;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public abstract void drive(double distance);
    public abstract void refuel(double liters);
}
