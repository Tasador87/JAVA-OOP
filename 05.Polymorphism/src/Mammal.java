import java.text.DecimalFormat;

public abstract class Mammal extends Animal {

    protected String livingRegion;

    public Mammal(String animalName, String animalType, Double animalWeight, Integer foodEaten, String livingRegion) {
        super(animalName, animalType, animalWeight, foodEaten);
        this.livingRegion = livingRegion;
    }

    public String getLivingRegion() {
        return this.livingRegion;
    }

    @Override
    public void eat(Food food) {
        this.setFoodEaten(this.getFoodEaten() + food.getQuantity());
    }

    @Override
    public String toString() {
        DecimalFormat format = new DecimalFormat("#.##");
        String formatedWeight = format.format(getAnimalWeight());
        return String.format("%s[%s, %s, %s, %d]", this.getAnimalType(), this.getAnimalName(), formatedWeight, this.getLivingRegion(), this.getFoodEaten());

    }
}