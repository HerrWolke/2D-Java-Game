package de.mrcloud;

import de.mrcloud.game.Game;
import de.mrcloud.gfx.Camera;
import de.mrcloud.handlers.InputHandler;
import de.mrcloud.worldgen.World;

public class Handler {

    private Game game;
    private World world;

    public Handler(Game game) {
        this.game = game;
    }

    public Camera getCamera() {
        return game.getCamera();
    }

    public InputHandler getInputHandler() {
        return game.getInputHandler();
    }


    public int getWidth() {
        return game.getWidth();
    }

    public int getHeight() {
        return game.getHeight();
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }
}
