import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<String> animals = new ArrayList<>();

        while (!input.equals("End")) {
            String[] animalData = input.split("\\s+"); //{AnimalType} {AnimalName} {AnimalWeight} {AnimalLivingRegion} [{CatBreed} = Only if its cat] //Cat Gray 1.1 Home Persian
            String type = animalData[0];
            String name = animalData[1];
            double weight = Double.parseDouble(animalData[2]);
            String livingRegion = animalData[3];

            String[] foodData = scanner.nextLine().split("\\s+");
            String foodType = foodData[0];
            int quantity = Integer.parseInt(foodData[1]);

            if (type.equals("Cat")) {
                String breed = animalData[4];
                Animal cat = new Cat(name, type, weight, 0, livingRegion, breed);
                cat.makeSound();
                if (foodType.equals("Vegetable")) {
                    cat.eat(new Vegetable(quantity));
                } else {
                    cat.eat(new Meat(quantity));
                }
                animals.add(cat.toString());

            } else if (type.equals("Tiger")) {
                Animal tiger = new Tiger(name, type, weight, 0, livingRegion);
                tiger.makeSound();
                if (foodType.equals("Vegetable")) {
                    System.out.println("Tigers are not eating that type of food!");
                } else {
                    tiger.eat(new Meat(quantity));
                }
                animals.add(tiger.toString());

            } else if (type.equals("Mouse")) {
                Animal mouse = new Mouse(name, type, weight, 0, livingRegion);
                mouse.makeSound();
                if (foodType.equals("Vegetable")) {
                    mouse.eat(new Vegetable(quantity));
                } else {
                    System.out.println("Mice are not eating that type of food!");
                }
                animals.add(mouse.toString());

            } else if (type.equals("Zebra")) {
                Animal zebra = new Zebra(name, type, weight, 0, livingRegion);
                zebra.makeSound();
                if (foodType.equals("Vegetable")) {
                    zebra.eat(new Vegetable(quantity));
                } else {
                    System.out.println("Zebras are not eating that type of food!");
                }
                animals.add(zebra.toString());
            }
            input = scanner.nextLine();
        }
        for (String animal : animals) {
            System.out.println(animal);
        }
    }
}