package de.mrcloud.entities;

import de.mrcloud.Handler;
import de.mrcloud.entities.creatures.Player;

import java.awt.*;
import java.util.ArrayList;

public class EntityManager {
    private Handler handler;
    private Player player;
    private ArrayList<Entity> entities;

    public EntityManager(Handler handler, Player player) {
        this.handler = handler;
        this.player = player;
        entities = new ArrayList<>();
    }


    public void tick() {
        for (int i = 0; i < entities.size(); i++) {
            Entity entity = entities.get(i);
            entity.tick();
        }
        player.tick();
    }

    public void render(Graphics g) {
        for (Entity entity : entities) {
            entity.render(g);
        }
        player.render(g);
    }

    public void addEntity(Entity e) {
        entities.add(e);
    }

    public void removeEntity(Entity e) {
        entities.remove(e);
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
