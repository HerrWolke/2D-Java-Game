package de.mrcloud.states;

import de.mrcloud.entities.creatures.Player;
import de.mrcloud.game.Game;
import de.mrcloud.gfx.AssetsContainer;
import de.mrcloud.utils.Coordinates;
import de.mrcloud.worldgen.World;

import java.awt.*;

public class GameState extends State {
    AssetsContainer assets;
    private Player player;
    private World world;


    public GameState(Game game) {
        super(game);
        assets = new AssetsContainer();
        assets.init();
        assets.initCharacters();
        player = new Player(game, new Coordinates(100, 100), 10);
        world = new World(game,"res/world/world.txt");
    }

    @Override
    public void tick() {
        world.tick();
        player.tick();
    }

    @Override
    public void render(Graphics graphics) {
        world.render(graphics);
        player.render(graphics, assets);
    }
}
