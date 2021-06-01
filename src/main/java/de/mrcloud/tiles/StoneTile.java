package de.mrcloud.tiles;

import de.mrcloud.gfx.AssetsContainer;

public class StoneTile extends Tile {
    public StoneTile(int id) {
        super(AssetsContainer.stone, id);
    }

    @Override
    public boolean isSolid() {
        return true;
    }
}
