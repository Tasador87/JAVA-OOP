package Exercises.AnimalFarm_02;

public class Chicken {
    private String name;
    private int age;

    public Chicken(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }

    private String getName() {
        return this.name;
    }

    private void setName(String name) {
        if (name.isEmpty() || name.matches("\\s+")) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.name = name;
    }

    private int getAge() {
        return this.age;
    }

    private void setAge(int age) {
        if (age < 0 || age > 15) {
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        }
        this.age = age;
    }

    public double productPerDay() {
        return calculateProductPerDay();
    }

    private double calculateProductPerDay() {
        double egssPersDay;
        if (this.getAge() <= 5) {
            egssPersDay = 2.0;
        } else if (this.getAge() <= 11) {
            egssPersDay = 1.0;
        } else {
            egssPersDay = 0.75;
        }
        return egssPersDay;
    }

    @Override
    public String toString() {
        return String.format("Chicken %s (age %d) can produce %.2f eggs per day.", this.getName(), this.getAge(), this.productPerDay());
    }

}
