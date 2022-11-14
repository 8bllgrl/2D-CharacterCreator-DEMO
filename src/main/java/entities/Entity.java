package entities;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public abstract class Entity {

    protected int x, y;
    protected int width, height;
    protected Rectangle2D.Float hitbox;
    protected int animationTick, animationIndex;

    public Entity(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public Rectangle2D.Float getHitbox() {
        return hitbox;
    }

    public int getAniIndex() {
        return animationIndex;
    }
}
