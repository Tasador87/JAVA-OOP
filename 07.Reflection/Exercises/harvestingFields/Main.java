package Exercises.harvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Class richSoilLand = RichSoilLand.class;
        Field[] fields = richSoilLand.getDeclaredFields();

        String inputData = scanner.nextLine();
        while (!inputData.equals("HARVEST")) {

            for (Field field : fields) {

                if (inputData.equals("private")) {
                    if (Modifier.isPrivate(field.getModifiers())) {
                        System.out.println(String.format("%s %s %s", Modifier.toString(field.getModifiers()), field.getType().getSimpleName(), field.getName()));
                    }
                } else if (inputData.equals("public")) {
                    if (Modifier.isPublic(field.getModifiers())) {
                        System.out.println(String.format("%s %s %s", Modifier.toString(field.getModifiers()), field.getType().getSimpleName(), field.getName()));
                    }
                } else if (inputData.equals("protected")) {
                    if (Modifier.isProtected(field.getModifiers())) {
                        System.out.println(String.format("%s %s %s", Modifier.toString(field.getModifiers()), field.getType().getSimpleName(), field.getName()));
                    }
                } else if (inputData.equals("all")) {
                    System.out.println(String.format("%s %s %s", Modifier.toString(field.getModifiers()), field.getType().getSimpleName(), field.getName()));
                }
            }
            inputData = scanner.nextLine();
        }
    }
}