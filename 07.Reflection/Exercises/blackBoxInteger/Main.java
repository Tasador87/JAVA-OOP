package Exercises.blackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {

        Scanner scanner = new Scanner(System.in);

        Constructor<BlackBoxInt> constr = BlackBoxInt.class.getDeclaredConstructor();
        constr.setAccessible(true);
        BlackBoxInt box = constr.newInstance();

        Method[] methods = BlackBoxInt.class.getDeclaredMethods();

        Field innerValue = BlackBoxInt.class.getDeclaredField("innerValue");
        innerValue.setAccessible(true);


        String input = scanner.nextLine();
        while (!input.equals("END")) {

            String[] commands = input.split("_");
            String command = commands[0];
            int value = Integer.parseInt(commands[1]);

            for (Method method : methods) {
                if (command.equals(method.getName())) {

                    method.setAccessible(true);
                    method.invoke(box, value);
                    System.out.println(innerValue.getInt(box));
                }
            }
            input = scanner.nextLine();
        }
    }
}