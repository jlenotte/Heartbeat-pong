package heartbeat.pong;


import java.awt.*;

/**
 * Created by Jules on 07/05/2017.
 */

public class HUD {

  public static int score1 = 0;
  public static int score2 = 0;

  public void tick() {
    
  }

  public void render(Graphics graphics) {

    graphics.fillRect(960, 0, 2, 1080);
    graphics.drawString("PLAYER", 400, 20);
    graphics.drawString("ENEMY", 1200, 20);
    graphics.drawString("SCORE : " + score1, 300, 20);
    graphics.drawString("SCORE : " + score2, 1300, 20);

  }

  public void score(int score) {
    this.score2 = score;
  }

  public int getScore1() {

    return score1;

  }

  public void setScore1(int score1) {

    this.score1 = score1;

  }

  public int getScore2() {

    return score2;

  }

  public void setScore2(int score2) {

    this.score2 = score2;

  }
}
