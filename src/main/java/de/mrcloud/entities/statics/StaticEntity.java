package de.mrcloud.entities.statics;

import de.mrcloud.Handler;
import de.mrcloud.entities.Entity;
import de.mrcloud.utils.Coordinates;

public abstract class StaticEntity extends Entity {
    public StaticEntity(Handler handler, Coordinates coordinates, int width, int height) {
        super(handler, coordinates, width, height);
    }
}
