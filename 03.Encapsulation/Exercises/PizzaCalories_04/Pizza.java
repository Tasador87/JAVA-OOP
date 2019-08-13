package Exercises.PizzaCalories_04;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String name;
    private Dough dough;
    private List<Topping> toppings;
    private int numberOfToppings;

    public Pizza(String name, int numberOfToppings) {
        this.setName(name);
        this.setToppings(numberOfToppings);
        this.toppings = new ArrayList<>(numberOfToppings);
    }

    private void setName(String name) {
        Validator.validatePizzaName(name);
        this.name = name;
    }

    private void setToppings(int numberOfToppings) {
        Validator.validateNumberOfToppings(numberOfToppings);
        this.numberOfToppings = numberOfToppings;
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    public String getName() {
        return this.name;
    }

    public void addTopping(Topping topping) {
        this.toppings.add(topping);
    }

    public double getOverallCalories() {
        double allToppingsCalories = 0.0;
        for (Topping topping : toppings) {
            allToppingsCalories += topping.calculateCalories();
        }
        double getOverallcalories = dough.calculateCalories() + allToppingsCalories;
        return getOverallcalories;
    }
}
