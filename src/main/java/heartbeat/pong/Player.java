package heartbeat.pong;

import java.awt.*;
import java.util.Random;

/**
 * Created by Jules on 07/05/2017.
 */

public class Player extends GameObject {

  Random rndm = new Random();
  Handler handler;

  public Player(int x, int y, ID id, Handler handler) {

    super(x, y, id);
    this.handler = handler;

  }

  public Rectangle getBounds() {

    return new Rectangle((int) x, (int) y, 18, 68);

  }

  public void tick() {

    x += spdX;
    y += spdY;

    x = Game.playerCollision((int) x, 0, Game.WIDTH - 47);
    y = Game.playerCollision((int) y, 0, Game.HEIGHT - 57);

    collision();

  }

  private void collision() {

    for (int i = 0; i < handler.object.size(); i++) {

      GameObject tempObject = handler.object.get(i);

      if (tempObject.getId() == ID.Ball) {

        if (getBounds().intersects(tempObject.getBounds())) {

          // rebound code
          x += spdX;
          y += spdY;

          if (y <= 0 || y >= Game.HEIGHT - 12) {
            spdY *= -1;
          }
          if (x <= 0 || x >= Game.WIDTH - 16) {
            spdX *= -1;
          }
        }

      }

    }

  }

  public void render(Graphics graphics) {

//        Graphics2D g2d = (Graphics2D) graphics;
//        graphics.setColor(Color.GREEN);
//        g2d.draw(getBounds());

    graphics.setColor(Color.WHITE);
    graphics.drawRect((int) x, (int) y, 18, 68);

  }

}
