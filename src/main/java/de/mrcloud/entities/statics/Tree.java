package de.mrcloud.entities.statics;

import de.mrcloud.Handler;
import de.mrcloud.gfx.AssetsContainer;
import de.mrcloud.tiles.Tile;
import de.mrcloud.utils.Coordinates;

import java.awt.*;

public class Tree extends StaticEntity{
    public Tree(Handler handler, Coordinates coordinates) {
        super(handler, coordinates, Tile.TILE_WIDTH * 2, Tile.TILE_HEIGHT * 2);

        bounds.x = 10;
        bounds.y = (int) (height / 1.5f);
        bounds.width = width - 20;
        bounds.height = (int) (height - height / 1.5f);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawImage(AssetsContainer.tree,(int)(coordinates.getX() - handler.getCamera().getxOffset()),(int)(coordinates.getY() - handler.getCamera().getyOffset()),width,height, null);
    }
}
