package Lections.Ferrari_06;

public class Ferrari implements Car {

    private String driverName;
    private String model;
    private String brakes;
    private String gas;

    public Ferrari(String driverName) {
        this.driverName = driverName;
    }

    public String setModel() {
        return "488-Spider";
    }

    @Override
    public String brakes() {
        return "Brakes!";
    }

    @Override
    public String gas() {
        return "brum-brum-brum-brrrrr";
    }

    @Override
    public String toString() {
        return String.format("%s/%s/%s/%s",setModel(),brakes(),gas(),this.driverName);
    }
}
