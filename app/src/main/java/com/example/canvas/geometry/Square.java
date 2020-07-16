package com.example.canvas.geometry;

import android.graphics.Color;

public class Square extends Figure implements ColorChangeable {
    private int width;
    private Color color;

    public Color getColor() {
        return color;
    }


    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public void changeColor(Color color) {
        this.color = color;
    }
}
