package Lections.CarShopExtended_02;

public class Seat extends CarImpl implements Sellable {
    private Double price;

    public Seat(String model, String color, Integer horsePower, String country, Double price) {
        super(model, color, horsePower, country);
        this.price = price;
    }

    @Override
    public Double getPrice() {
        return this.price;
    }

    @Override
    public String toString() {
        String print = String.format("%s sells for %f",this.getModel(),this.getPrice());
        return super.toString() + System.lineSeparator() + print;
    }
}
