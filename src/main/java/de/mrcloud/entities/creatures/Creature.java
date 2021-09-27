package de.mrcloud.entities.creatures;

import de.mrcloud.Handler;
import de.mrcloud.entities.Entity;
import de.mrcloud.tiles.Tile;
import de.mrcloud.utils.Coordinates;

public abstract class Creature extends Entity {
    public static final int DEFAULT_HEALTH = 10;
    public static final float DEFAULT_SPEED = 3.0f;
    public static final int DEFAULT_CREATURE_WIDTH = 64,
            DEFAULT_CREATURE_HEIGHT = 64;

    protected int health;
    protected float speed;
    protected float xMove, yMove;


    public Creature(Handler handler, Coordinates coordinates, int health, int width, int height) {
        super(handler, coordinates, width, height);
        this.health = health;
        this.speed = DEFAULT_SPEED;
        xMove = 0;
        yMove = 0;
    }


    public void move() {
        moveX();
        moveY();

    }

    public void moveX() {
        //Checks if moving right or left
        if (xMove > 0) {
            int tx = (int) ((coordinates.getX() + xMove + bounds.x + bounds.width) / Tile.TILE_WIDTH);
            if((!collisionWithTile(tx,(int) ((coordinates.getY()+bounds.y) / Tile.TILE_HEIGHT))) && !collisionWithTile(tx,(int) ((coordinates.getY()+bounds.y + bounds.height) / Tile.TILE_HEIGHT))) {
                coordinates.addToX(xMove);
            } else {
                coordinates.setX(tx * Tile.TILE_WIDTH - bounds.x - bounds.width - 1);
            }

        } else if (xMove < 0) {
            int tx = (int) ((coordinates.getX() + xMove + bounds.x) / Tile.TILE_WIDTH);
            if((!collisionWithTile(tx,(int) ((coordinates.getY()+bounds.y) / Tile.TILE_HEIGHT))) && !collisionWithTile(tx,(int) ((coordinates.getY()+bounds.y + bounds.height) / Tile.TILE_HEIGHT))) {
                coordinates.addToX(xMove);
            } else {
                coordinates.setX(tx * Tile.TILE_WIDTH + Tile.TILE_WIDTH - bounds.x);
            }
        }
    }

    public void moveY() {
        //Checking if moving up or down
        if(yMove < 0) {
            int ty = (int) (coordinates.getY() + yMove + bounds.y) / Tile.TILE_HEIGHT;

            if((!collisionWithTile((int) ((coordinates.getX() + bounds.x ) / Tile.TILE_WIDTH),ty))
            && (!collisionWithTile((int) ((coordinates.getX() + bounds.x + bounds.width ) / Tile.TILE_WIDTH),ty))) {
                coordinates.addToY(yMove);
            } else {
                coordinates.setY(ty * Tile.TILE_HEIGHT + Tile.TILE_HEIGHT - bounds.y);
            }
        } else if ( yMove > 0) {
            int ty = (int) (coordinates.getY() + yMove + bounds.y + bounds.height) / Tile.TILE_HEIGHT;

            if((!collisionWithTile((int) ((coordinates.getX() + bounds.x ) / Tile.TILE_WIDTH),ty))
                    && (!collisionWithTile((int) ((coordinates.getX() + bounds.x + bounds.width ) / Tile.TILE_WIDTH),ty))) {
                coordinates.addToY(yMove);
            } else {
                coordinates.setY(ty * Tile.TILE_HEIGHT - bounds.y - bounds.height - 1);
            }
        }
    }

    protected boolean collisionWithTile(int x, int y) {
        return handler.getWorld().getTile(x, y).isSolid();
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public float getxMove() {
        return xMove;
    }

    public void setxMove(float xMove) {
        this.xMove = xMove;
    }

    public float getyMove() {
        return yMove;
    }

    public void setyMove(float yMove) {
        this.yMove = yMove;
    }
}
