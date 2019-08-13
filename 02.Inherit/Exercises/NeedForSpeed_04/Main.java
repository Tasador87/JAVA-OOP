package Exercises.NeedForSpeed_04;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        SportCar sportCar = new SportCar(11,150);

        sportCar.drive(1);

        System.out.println(sportCar.getFuel());
    }
}
