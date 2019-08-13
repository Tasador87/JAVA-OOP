package Exercises.barracksWars;

import Exercises.barracksWars.core.Engine;
import Exercises.barracksWars.core.factories.UnitFactoryImpl;
import Exercises.barracksWars.data.UnitRepository;
import Exercises.barracksWars.interfaces.Repository;
import Exercises.barracksWars.interfaces.Runnable;
import Exercises.barracksWars.interfaces.UnitFactory;

import java.util.Scanner;

public class Main {
    private static String value;

    public static void main(String[] args) {

        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        Runnable engine = new Engine(repository, unitFactory);
        engine.run();

        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();

        System.out.println(name);
    }

    public static String IsNullOrEmpty() {
        return String.valueOf(value == null || value.isEmpty());
    }
}