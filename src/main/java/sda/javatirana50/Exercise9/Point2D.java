package sda.javatirana50.Exercise9;

import sda.javatirana50.Exercise10.Movable;
import sda.javatirana50.Exercise10.MoveDirection;

public class Point2D implements Movable {
    public double x;
    public double y;

    public Point2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public void move(MoveDirection direction) {
        this.x += direction.getX();
        this.y += direction.getY();
    }
}
