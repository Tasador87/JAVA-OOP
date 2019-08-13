package Lections.Shapes_02;

public abstract class Shape {
    private Double perimeter;
    private Double area;

    private Double getPerimeter() {
        return perimeter;
    }

    protected void setPerimeter(Double perimeter) {
        this.perimeter = perimeter;
    }

    private Double getArea() {
        return area;
    }

    protected void setArea(Double area) {
        this.area = area;
    }

    public abstract void calculatePerimeter();

    public abstract void calculateArea();
}
