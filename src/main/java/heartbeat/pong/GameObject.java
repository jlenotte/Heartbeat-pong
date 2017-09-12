package heartbeat.pong;

import java.awt.*;

/**
 * Created by Jules on 07/05/2017.
 */

// GameObject will be all objects in our game, enemies, players, all are considered GameObject's

public abstract class GameObject {

    protected int x, y;
    protected ID id;
    protected int spdX, spdY;

    public GameObject(int x, int y, ID id) {

        this.x = x;
        this.y = y;
        this.id = id;

    }

    public abstract void tick();

    public abstract void render(Graphics graphics);

    public abstract Rectangle getBounds();


    public void setX(int x) {

        this.x = x;

    }

    public void setY(int y) {

        this.y = y;

    }

    public float getX() {

        return x;

    }

    public float getY() {

        return y;

    }

    public void setId(ID id) {

        this.id = id;

    }

    public ID getId() {

        return id;

    }

    public void setSpdX(int spdX) {

        this.spdX = spdX;

    }

    public void setSpdY(int spdY) {

        this.spdY = spdY;

    }

    public float getSpdX() {

        return spdX;

    }

    public float getSpdY() {

        return spdY;

    }

}
