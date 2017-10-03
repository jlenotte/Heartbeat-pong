package heartbeat.pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Ball extends GameObject {

  private Handler handler;
  private HUD hud;
  private static int score;

  public Ball(int x, int y, ID id, Handler handler) {

    super(x, y, id);

    this.handler = handler;

    spdX = (float) 1.5;
    spdY = (float) 1.5;


  }

  public Rectangle getBounds() {

    return new Rectangle((int) x, (int) y, 12, 12);

  }


  /**
   *  * Makes the ball rebound when hitting the borders
   */
  public void tick() {

    y += spdY;
    x += spdX;

    if (y <= 0 || y >= Game.HEIGHT - 9) {
      spdY *= -1;
    }

    if (x <= 0 || x >= Game.WIDTH - 9) {
      spdX *= -1;
      // make the score +1 if an edge is hit
      // hud.setScore1(hud.getScore1() + 1);
    }

    collision();

  }

  /**
   * collision with the enemy or the player
   */
  public void collision() {
    for (int i = 0; i < handler.object.size(); i++) {
      GameObject tempObject = handler.object.get(i);

      if (tempObject.getId() == ID.Player || tempObject.getId() == ID.Enemy) {
        if (getBounds().intersects(tempObject.getBounds())) {
          spdX *= -1;
        }
      } else if (tempObject.getId() == ID.BoundaryE) {
        if (getBounds().intersects(tempObject.getBounds())) {
          spdX *= -1;
          HUD.score1 ++;
        }
      } else if (tempObject.getId() == ID.BoundaryP) {
        if (getBounds().intersects(tempObject.getBounds())) {
          spdX *= -1;
          HUD.score2 ++;
        }
      }

    }

    handler.addObject(new Trail((int) x, (int) y, ID.Trail, Color.WHITE, 12, 12, 0.009f, handler));
  }

  public void render(Graphics graphics) {

    graphics.setColor(Color.WHITE);
    graphics.fillRect((int) x, (int) y, 12, 12);

  }


}
