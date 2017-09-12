package heartbeat.pong;


import java.awt.*;

/**
 * Created by Jules on 07/05/2017.
 */

public class HUD {

  private int level = 1;
  private int score = 0;

  public void tick() {

    score++;

  }

  public void render(Graphics graphics) {

    graphics.fillRect(800, 0, 5, 900);
    graphics.drawString("PLAYER", 400, 20);
    graphics.drawString("ENEMY", 1200, 20);
    graphics.drawString("Level : " + level, 20, 50);
    graphics.drawString("Score : " + score, 20, 80);

  }

  public void score(int score) {
    this.score = score;
  }

  public int getLevel() {

    return level;

  }

  public void setLevel(int level) {

    this.level = level;

  }

  public int getScore() {

    return score;

  }

  public void setScore(int score) {

    this.score = score;

  }
}
