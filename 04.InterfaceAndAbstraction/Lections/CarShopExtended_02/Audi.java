package Lections.CarShopExtended_02;

public class Audi extends CarImpl implements Rentable {
    private Integer minRentDay;
    private Double pricePerDay;

    public Audi(String model, String color, Integer horsePower, String country, Integer minRentDay, Double pricePerDay) {
        super(model, color, horsePower, country);
        this.minRentDay = minRentDay;
        this.pricePerDay = pricePerDay;
    }

    @Override
    public Integer minRentDay() {
        return this.minRentDay;
    }

    @Override
    public Double pricePerDay() {
        return this.pricePerDay;
    }

    @Override
    public String toString() {
        String print = String.format("Minimum rental period of %d days. Price per day %f",this.minRentDay(),this.pricePerDay());
        return super.toString() + System.lineSeparator() + print;
    }
}
