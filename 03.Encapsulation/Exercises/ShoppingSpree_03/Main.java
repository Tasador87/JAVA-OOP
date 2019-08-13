package Exercises.ShoppingSpree_03;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] allNames = scanner.nextLine().split(";");
        String[] products = scanner.nextLine().split(";");
        List<Person> people = new ArrayList<>();

        //Pesho=11 Gosho=4
        for (int i = 0; i < allNames.length ; i++) {
            String[] data = allNames[i].split("=");
            String name = data[0];
            double money = Double.parseDouble(data[1]);
            Person person = new Person(name,money);
            people.add(person);
        }

    }
}
