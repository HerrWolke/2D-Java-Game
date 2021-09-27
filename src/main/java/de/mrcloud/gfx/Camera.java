package de.mrcloud.gfx;

import de.mrcloud.Handler;
import de.mrcloud.entities.Entity;
import de.mrcloud.game.Game;
import de.mrcloud.tiles.Tile;

public class Camera {
    private float xOffset, yOffset;
    private Handler handler;

    public Camera(Handler handler, float xOffset, float yOffset) {
        this.handler = handler;
        this.xOffset = xOffset;
        this.yOffset = yOffset;
    }

    public void checkBlancSpace() {
        if(xOffset < 0 ) {
            xOffset = 0;
        } else if(xOffset > handler.getWorld().getWidth() * Tile.TILE_WIDTH - handler.getWidth()) {
            xOffset = handler.getWorld().getWidth() * Tile.TILE_WIDTH - handler.getWidth();
        }

        if(yOffset < 0) {
            yOffset = 0;
        }else if(yOffset > handler.getWorld().getHeight() * Tile.TILE_HEIGHT - handler.getHeight()) {
            yOffset = handler.getWorld().getHeight() * Tile.TILE_HEIGHT - handler.getHeight();
        }
    }

    public void centerOnEntity(Entity e) {
        xOffset = e.getCoordinates().getX() - handler.getWidth() / 2 + e.getWidth() / 2;
        yOffset = e.getCoordinates().getY() - handler.getHeight() / 2 + e.getHeight() / 2;
        checkBlancSpace();
    }

    public void move(float xAmt, float yAmt) {
        xOffset += xAmt;
        yOffset += yAmt;
        checkBlancSpace();
    }

    public float getxOffset() {
        return xOffset;
    }

    public float getyOffset() {
        return yOffset;
    }
}
