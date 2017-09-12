package heartbeat.pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Enemy extends GameObject {

  private Handler handler;
  private GameObject ball;
  private static final Logger LOG = LoggerFactory.getLogger(Enemy.class);

  public Enemy(int x, int y, ID id, Handler handler) {

    super(x, y, id);
    this.handler = handler;

    for (int i = 0; i < handler.object.size(); i++) {

      if (handler.object.get(i).getId() == ID.Ball) {
        ball = handler.object.get(i);
      }

    }
  }

  public Rectangle getBounds() {

    return new Rectangle((int) x, (int) y, 18, 68);

  }

  public void tick() {

    x += spdX;
    y += spdY;

    float diffY = y - ball.getY() - 34;
    float distance = (float) Math.sqrt((y - ball.getY()) * (y - ball.getY()));

    spdY = ((-1 / distance) * diffY);

    if (y <= 0 || y > Game.HEIGHT - 96) {
      spdY *= -1;
    }
    LOG.debug(String.valueOf(spdY));

  }

  public void render(Graphics graphics) {

    graphics.setColor(Color.WHITE);
    graphics.drawRect((int) x, (int) y, 18, 68);

  }
}
