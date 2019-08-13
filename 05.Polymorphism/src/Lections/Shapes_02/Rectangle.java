package Lections.Shapes_02;

public class Rectangle extends Shape {

    private Double height;
    private Double width;

    public Rectangle(Double height, Double width) {
        this.height = height;
        this.width = width;
    }

    public final Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public final Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    @Override
    public void calculatePerimeter() {
        Double result = 2 *(this.height + this.width);
        super.setPerimeter(result);
    }

    @Override
    public void calculateArea() {
        Double result = this.height * this.width;
        super.setArea(result);
    }
}
