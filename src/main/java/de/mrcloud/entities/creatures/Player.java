package de.mrcloud.entities.creatures;

import de.mrcloud.game.Game;
import de.mrcloud.gfx.AssetsContainer;
import de.mrcloud.utils.Coordinates;

import java.awt.*;

public class Player extends Creature {


    public Player(Game game, Coordinates coordinates, int health) {
        super(game,coordinates, health, DEFAULT_CREATURE_WIDTH, DEFAULT_CREATURE_HEIGHT);
    }

    @Override
    public void tick() {
        getInput();
        move();
    }

    private void getInput() {
        xMove = 0;
        yMove = 0;

        if (game.getInputHandler().up)
            yMove = -speed;

        if (game.getInputHandler().down)
            yMove = speed;

        if (game.getInputHandler().left)
            xMove = -speed;

        if (game.getInputHandler().right)
            xMove = speed;
    }

    @Override
    public void render(Graphics graphics, AssetsContainer assets) {
        graphics.drawImage(assets.chracterSprites.get(2), (int) coordinates.getX(), (int) coordinates.getY(), width, height, null);
    }
}
