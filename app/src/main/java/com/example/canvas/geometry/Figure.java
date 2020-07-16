package com.example.canvas.geometry;

public abstract class Figure extends Point {

    private int offsetX, offsetY;

    public void offset(){
        setX(getX() + offsetX);
        setY(getY() + offsetY);
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

}
