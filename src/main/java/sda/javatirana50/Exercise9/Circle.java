package sda.javatirana50.Exercise9;

import sda.javatirana50.Exercise10.Movable;
import sda.javatirana50.Exercise10.MoveDirection;
import sda.javatirana50.Exercise11.Resizable;

import java.util.List;

public class Circle implements Movable, Resizable {
    private Point2D center;
    private Point2D point;

    public Circle(Point2D center, Point2D point) {
        this.center = center;
        this.point = point;
    }

    public double getRadius() {
        return Math.sqrt(Math.pow(point.getX() - center.getX(), 2) + Math.pow(point.getY() - center.getY(), 2));
    }

    public double getArea(){
        return Math.PI * Math.pow(getRadius(), 2);
    }

    public double getPerimeter(){
        return 2 * Math.PI * getRadius();
    }

    // TODO  three points on the circle every 90 degrees
    //  from the point given when calling the
    //  List<Point2D> getSlicePoints() method
    public List<Point2D> getSlicePoints(){


        return null;
    }


    @Override
    public void move(MoveDirection direction) {
        this.center.move(direction);
        this.point.move(direction);
    }


    // TODO implement Method
    @Override
    public void resize(float factor) {
        
    }
}
