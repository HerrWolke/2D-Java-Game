package de.mrcloud.states;

import de.mrcloud.Handler;
import de.mrcloud.entities.creatures.Player;
import de.mrcloud.entities.statics.Tree;
import de.mrcloud.gfx.AssetsContainer;
import de.mrcloud.utils.Coordinates;
import de.mrcloud.worldgen.World;

import java.awt.*;

public class GameState extends State {
    AssetsContainer assets;
    private World world;


    public GameState(Handler handler) {
        super(handler);
        assets = new AssetsContainer();
        assets.init();
        assets.initCharacters();
        world = new World(handler, "res/world/world.txt");
        handler.setWorld(world);
    }

    @Override
    public void tick() {
        world.tick();
    }

    @Override
    public void render(Graphics graphics) {

        world.render(graphics);
    }
}
