package Lections.Shapes_02;

public class Circle extends Shape {

    private Double radius;

    public Circle(Double radius) {
        this.radius = radius;
    }

    public final Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    @Override
    public void calculatePerimeter() {
        Double result = 2 * Math.PI * this.radius;
        super.setPerimeter(result);
    }

    @Override
    public void calculateArea() {
        Double result = Math.PI * Math.pow(this.radius, 2);
        super.setArea(result);
    }
}
