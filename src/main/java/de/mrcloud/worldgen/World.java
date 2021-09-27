package de.mrcloud.worldgen;

import de.mrcloud.Handler;
import de.mrcloud.entities.Entity;
import de.mrcloud.entities.EntityManager;
import de.mrcloud.entities.creatures.Player;
import de.mrcloud.entities.statics.Tree;
import de.mrcloud.tiles.Tile;
import de.mrcloud.utils.Coordinates;
import de.mrcloud.window.Utils;

import java.awt.*;

public class World {
    private int width, height;
    private int spawnX, spawnY;
    private int[][] tiles;
    private Handler handler;
    private EntityManager entityManager;

    public World(Handler handler, String path) {
        this.handler = handler;
        entityManager = new EntityManager(handler,new Player(handler,new Coordinates(100,100),100));
        loadWorld(path);
        entityManager.addEntity(new Tree(handler,new Coordinates(100,100)));
        entityManager.addEntity(new Tree(handler,new Coordinates(323,330)));
        entityManager.addEntity(new Tree(handler,new Coordinates(600,140)));

        entityManager.getPlayer().setCoordinates(new Coordinates(spawnX,spawnY));
    }

    public void tick() {
        entityManager.tick();
    }

    public void render(Graphics g) {
        int xStart = (int) Math.max(0, handler.getCamera().getxOffset() / Tile.TILE_WIDTH);
        int xEnd = (int) Math.min(width, (handler.getCamera().getxOffset() + handler.getWidth()) / Tile.TILE_WIDTH + 1);
        int yStart = (int) Math.max(0, handler.getCamera().getyOffset() / Tile.TILE_HEIGHT);
        int yEnd = (int) Math.min(height, (handler.getCamera().getyOffset() + handler.getHeight()) / Tile.TILE_HEIGHT + 1);


        for (int y = yStart; y < yEnd; y++) {
            for (int x = xStart; x < xEnd; x++) {
                getTile(x, y).render(g, (int) (x * Tile.TILE_WIDTH - handler.getCamera().getxOffset()), (int) (y * Tile.TILE_HEIGHT - handler.getCamera().getyOffset()));
            }
        }

        entityManager.render(g);
    }

    public Tile getTile(int x, int y) {
        if(x < 0 || y < 0 || x >= width ||y >= height) return Tile.grassTile;

        Tile t = null;
        try {
            t = Tile.tiles[tiles[x][y]];
        } catch (IndexOutOfBoundsException ex) {

            System.out.println("There was an error in the rendering engine. The game will exit");
            ex.printStackTrace();
            System.exit(22);
        }


        if (t == null)
            System.exit(22);

        return t;

    }

    private void loadWorld(String path) {
        String file = Utils.loadFileAsString(path);
        String[] tokens = file.split("\\s+");

        width = Utils.parseInt(tokens[0]);
        height = Utils.parseInt(tokens[1]);

        spawnX = Utils.parseInt(tokens[2]);
        spawnY = Utils.parseInt(tokens[3]);

        tiles = new int[width][height];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                tiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 4]);
            }
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
