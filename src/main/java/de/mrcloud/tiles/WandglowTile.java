package de.mrcloud.tiles;

import de.mrcloud.gfx.AssetsContainer;

import java.awt.image.BufferedImage;

public class WandglowTile extends Tile{
    public WandglowTile(int id) {
        super(AssetsContainer.wandglow, id);
    }

    @Override
    public boolean isSolid() {
        return true;
    }
}
