package de.mrcloud.entities;

import de.mrcloud.game.Game;
import de.mrcloud.gfx.AssetsContainer;
import de.mrcloud.utils.Coordinates;

import java.awt.*;

public abstract class Entity {

    protected Coordinates coordinates;
    protected Game game;

    protected int width, height;

    public Entity(Game game, Coordinates coordinates, int width, int height) {
        this.game = game;
        this.coordinates = coordinates;
        this.width = width;
        this.height = height;
    }

    public abstract void tick();

    public abstract void render(Graphics graphics, AssetsContainer assets);

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
