package Lections.Animals_03;

public abstract class Animal {
    private String name;
    private String favouriteFood;

    public Animal(String name, String favouriteFood) {
        this.name = name;
        this.favouriteFood = favouriteFood;
    }

    private String getName() {
        return this.name;
    }

    private String getFavouriteFood() {
        return this.favouriteFood;
    }

    public String explainSelf(){
        return String.format("I am %s and my favourite food is %s",this.getName(),this.getFavouriteFood());
    }
}
