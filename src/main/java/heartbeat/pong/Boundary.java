package heartbeat.pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Boundary extends GameObject {
  private Handler handler;
  private GameObject ball;
  private static final Logger LOG = LoggerFactory.getLogger(Enemy.class);

  public Boundary(int x, int y, ID id, Handler handler) {

    super(x, y, id);
    this.handler = handler;

  }

  public Rectangle getBounds() {

    return new Rectangle((int) x, (int) y, 2, 1080);

  }

  public void tick() {

  }

  public void render(Graphics graphics) {

    graphics.setColor(Color.BLACK);
    graphics.drawRect((int) x, (int) y, 2, 1080);

  }
}
