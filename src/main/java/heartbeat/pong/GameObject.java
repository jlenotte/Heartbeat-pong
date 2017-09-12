package heartbeat.pong;

import java.awt.*;

/**
 * Created by Jules on 07/05/2017.
 */

// GameObject will be all objects in our game, enemies, players, all are considered GameObject's

public abstract class GameObject {

  protected float x, y;
  protected ID id;
  protected float spdX;
  protected float spdY;

  public GameObject(float x, float y, ID id) {

    this.x = x;
    this.y = y;
    this.id = id;

  }

  public abstract void tick();

  public abstract void render(Graphics graphics);

  public abstract Rectangle getBounds();


  public void setX(float x) {

    this.x = x;

  }

  public void setY(float y) {

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

  public void setSpdX(float spdX) {

    this.spdX = spdX;

  }

  public void setSpdY(float spdY) {

    this.spdY = spdY;

  }

  public float getSpdX() {

    return spdX;

  }

  public float getSpdY() {

    return spdY;

  }

}
