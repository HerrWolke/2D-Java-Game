package de.mrcloud.entities;

import de.mrcloud.Handler;
import de.mrcloud.game.Game;
import de.mrcloud.gfx.AssetsContainer;
import de.mrcloud.utils.Coordinates;

import java.awt.*;

public abstract class Entity {

    protected Coordinates coordinates;
    protected Handler handler;
    protected Rectangle bounds;

    protected int width, height;

    public Entity(Handler handler, Coordinates coordinates, int width, int height) {
        this.handler = handler;
        this.coordinates = coordinates;
        this.width = width;
        this.height = height;

        bounds = new Rectangle(0,0,64,64);
    }

    public abstract void tick();

    public abstract void render(Graphics graphics);

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
