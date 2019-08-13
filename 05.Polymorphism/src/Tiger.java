import java.text.DecimalFormat;

public class Tiger extends Felime {

    private String livingRegion;

    public Tiger(String animalName, String animalType, Double animalWeight, Integer foodEaten, String livingRegion) {
        super(animalName, animalType, animalWeight, foodEaten, livingRegion);
        this.livingRegion = livingRegion;
    }

    @Override
    public void makeSound() {
        System.out.println("ROAAR!!!");
    }

    @Override
    public String toString() {
        DecimalFormat format = new DecimalFormat("#.##");
        String formatedWeight = format.format(getAnimalWeight());
        return String.format("%s[%s, %s, %s, %d]", this.getAnimalType(), this.getAnimalName(), formatedWeight, this.livingRegion, this.getFoodEaten());

    }
}
