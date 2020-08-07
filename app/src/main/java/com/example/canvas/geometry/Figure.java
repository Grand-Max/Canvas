package com.example.canvas.geometry;

public abstract class Figure {

    private int offsetX, offsetY;
    private Point p;

    public Figure (){
        p = new Point();
    }

    public Point getP() {
        return p;
    }

    public void setP(Point p) {
        this.p = p;
    }

    public void offset(){
        p.setX(p.getX() + offsetX);
        p.setY(p.getY() + offsetY);
    }

    public int getOffsetX() {
        return offsetX;
    }

    public void setOffsetX(int offsetX) {
        this.offsetX = offsetX;
    }

    public int getOffsetY() {
        return offsetY;
    }

    public void setOffsetY(int offsetY) {
        this.offsetY = offsetY;
    }

    public int getX() {
        return p.getX();
    }

    public void setX(int x) {
        this.p.setX(x);
    }

    public int getY() {
        return p.getY();
    }

    public void setY(int y) {
        this.p.setY(y);
    }

}
