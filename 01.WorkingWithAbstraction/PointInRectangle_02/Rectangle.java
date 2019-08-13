package Lections.PointInRectangle_02;

public class Rectangle {
    private Point bottomLeft;
    private Point topRight;


    public Rectangle(Point bottomLeft, Point topRight) {
        this.bottomLeft = bottomLeft;
        this.topRight = topRight;
    }

    public Point getBottomLeft() {
        return bottomLeft;
    }

    public Point getTopRight() {
        return topRight;
    }
//0 0   3 3  // 1 1
    public boolean contains(Point point){
        boolean isBottomInside = point.getCordinateX() >= bottomLeft.getCordinateX() && point.getCordinateX() <= topRight.getCordinateX();

        boolean isTopInside = false;
        if (point.getCordinateY() <= topRight.getCordinateY() && point.getCordinateY() >= bottomLeft.getCordinateY() ){
            isTopInside = true;
        }

        boolean isInRectangle =  isBottomInside && isTopInside;
        return isInRectangle;
    }
}
