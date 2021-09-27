package de.mrcloud.entities.creatures;

import de.mrcloud.Handler;
import de.mrcloud.gfx.Animation;
import de.mrcloud.gfx.AssetsContainer;
import de.mrcloud.utils.Coordinates;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends Creature {

    private Animation animDown;
    private Animation animUp;
    private Animation animLeft;
    private Animation animRight;

    public Player(Handler handler, Coordinates coordinates, int health) {
        super(handler,coordinates, health, DEFAULT_CREATURE_WIDTH, DEFAULT_CREATURE_HEIGHT);

        bounds.x = 16;
        bounds.y = 32;
        bounds.width = 32;
        bounds.height = 32;

        animDown = new Animation(500,AssetsContainer.player_down);
        animUp = new Animation(500,AssetsContainer.player_up);
        animLeft = new Animation(500,AssetsContainer.player_left);
        animRight = new Animation(500,AssetsContainer.player_right);
    }

    @Override
    public void tick() {
        getInput();
        animDown.tick();
        animUp.tick();
        animRight.tick();
        animLeft.tick();
        move();
        handler.getCamera().centerOnEntity(this);
    }

    private void getInput() {
        xMove = 0;
        yMove = 0;

        if (handler.getInputHandler().up)
            yMove = -speed;

        if (handler.getInputHandler().down)
            yMove = speed;

        if (handler.getInputHandler().left)
            xMove = -speed;

        if (handler.getInputHandler().right)
            xMove = speed;
    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawImage(getCurrentAnimationFrame(), (int) (coordinates.getX()- handler.getCamera().getxOffset()), (int) (coordinates.getY() - handler.getCamera().getyOffset()), (int) (width * 1.25), (int) (height * 1.25), null);

//        graphics.setColor(Color.red);
//        graphics.fillRect((int) (coordinates.getX() + bounds.x - handler.getCamera().getxOffset()), (int) (coordinates.getY() + bounds.y - handler.getCamera().getyOffset()), bounds.width, bounds.height);
    }

    private BufferedImage getCurrentAnimationFrame() {
        if(xMove < 0 ) {
            return animLeft.getCurrentFrame();
        } else if(xMove > 0) {
            return animRight.getCurrentFrame();
        } else if(yMove < 0 ) {
            return animUp.getCurrentFrame();
        } else if(yMove > 0) {
            return animDown.getCurrentFrame();
        } else {
            // TODO: 03.06.2021 Add a still animation
            return animDown.getCurrentFrame();
        }
    }
}
