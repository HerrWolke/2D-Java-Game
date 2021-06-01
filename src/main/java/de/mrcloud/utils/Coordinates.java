package de.mrcloud.utils;

public class Coordinates {
    private float x;
    private float y;


    public Coordinates(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void addToY(float addition) {
        y += addition;
    }

    public void addToX(float addition) {
        x += addition;
    }

}
