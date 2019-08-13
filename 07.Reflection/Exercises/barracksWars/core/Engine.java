package Exercises.barracksWars.core;

import Exercises.barracksWars.interfaces.Runnable;
import Exercises.barracksWars.interfaces.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;

public class Engine implements Runnable {

    private static final String COMMAND_PACKAGE_NAME = "Exercises.barracksWars.core.commands.";

    private Repository repository;
    private UnitFactory unitFactory;

    public Engine(Repository repository, UnitFactory unitFactory) {
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    @Override
    public void run() {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        while (true) {
            try {
                String input = reader.readLine();
                String[] data = input.split("\\s+");
                String commandName = data[0];
                String result = interpretCommand(data, commandName);
                if (result.equals("fight")) {
                    break;
                }
                System.out.println(result);

            } catch (RuntimeException | ClassNotFoundException e) {
                System.out.println(e.getMessage());
            } catch (IOException | NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
                e.printStackTrace();
            }
        }
    }

    private String interpretCommand(String[] data, String commandName) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        String result = "Invalid command";
        commandName = Character.toUpperCase(commandName.charAt(0)) + commandName.substring(1);

        if (commandName.equals(Class.forName(COMMAND_PACKAGE_NAME + commandName).getSimpleName())) {

            Class command = Class.forName(COMMAND_PACKAGE_NAME + commandName);
            Executable constr = (Executable) command.getDeclaredConstructor(String[].class, Repository.class, UnitFactory.class)
                    .newInstance(data, this.repository, this.unitFactory);

            result = constr.execute();
        }
        return result;
    }
}
