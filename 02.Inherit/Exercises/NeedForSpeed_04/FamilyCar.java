package Exercises.NeedForSpeed_04;

public class FamilyCar extends Car {

    public FamilyCar(double fuel, int horsePower) {
        super(fuel, horsePower);
        super.setFuelConsumption(DEFAULT_FUEL_CONSUMPTION);
    }
}
