package com.example.canvas.geometry;

public class Circle extends Figure {
    private int radius;

    public Circle(int radius,int x,int y){
        this.radius = radius;
        this.setX(x);
        this.setY(y);
    }
    public Circle(){ }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
}
