package Exercises.VehiclesExtension_02;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] carData = scanner.nextLine().split("\\s+");  // "Car {initial fuel quantity} {liters per km} {tank capacity}"
        double carFuelQuantity = Double.parseDouble(carData[1]);
        double carFuelConsumption = Double.parseDouble(carData[2]);
        int carTankCapacity = Integer.parseInt(carData[3]);

        String[] truckData = scanner.nextLine().split("\\s+"); // "Truck {initial fuel quantity} {liters per km} {tank capacity}"
        double truckFuelQuantity = Double.parseDouble(truckData[1]);
        double truckFuelConsumption = Double.parseDouble(truckData[2]);
        int truckTankCapacity = Integer.parseInt(truckData[3]);

        String[] busData = scanner.nextLine().split("\\s+"); // Vehicle {initial fuel quantity} {liters per km} {tank capacity}
        double busFuelQuantity = Double.parseDouble(busData[1]);
        double busFuelConsumption = Double.parseDouble(busData[2]);
        int busTankCapacity = Integer.parseInt(busData[3]);

        Vehicle car = new Car(carFuelQuantity, carFuelConsumption,carTankCapacity);
        Vehicle truck = new Truck(truckFuelQuantity, truckFuelConsumption,truckTankCapacity);
        Bus bus = new Bus(busFuelQuantity,busFuelConsumption,busTankCapacity);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {

            String[] data = scanner.nextLine().split("\\s+");

            if (data[1].equals("Car")) {
                if (data[0].equals("Drive")) {
                    car.drive(Double.parseDouble(data[2]));
                } else if (data[0].equals("Refuel")) {
                    double liters = Double.parseDouble(data[2]);
                    if (liters > 0) {
                        car.refuel(liters);
                    }else {
                        System.out.println("Fuel must be a positive number");
                    }
                }


            } else if (data[1].equals("Truck")) {
                if (data[0].equals("Drive")) {
                    truck.drive(Double.parseDouble(data[2]));

                } else if (data[0].equals("Refuel")) {
                    double liters = Double.parseDouble(data[2]);
                    if (liters > 0) {
                        truck.refuel(liters);
                    }else {
                        System.out.println("Fuel must be a positive number");
                    }
                }
            } else if (data[1].equals("Bus")){

                if (data[0].equals("Drive")){
                    bus.drive(Double.parseDouble(data[2]));
                }else if (data[0].equals("DriveEmpty")){
                    bus.driveEmpty(Double.parseDouble(data[2]));

                } else if (data[0].equals("Refuel")) {
                    double liters = Double.parseDouble(data[2]);
                    if (liters > 0) {
                        bus.refuel(liters);
                    }else {
                        System.out.println("Fuel must be a positive number");
                    }
                }
            }
        }
        System.out.println(String.format("Car: %.2f",car.getFuelQuantity()));
        System.out.println(String.format("Truck: %.2f",truck.getFuelQuantity()));
        System.out.println(String.format("Bus: %.2f",bus.getFuelQuantity()));
    }
}