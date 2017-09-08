package heartbeat.pong;


import java.awt.*;

/**
 * Created by Jules on 07/05/2017.
 */

public class HUD {

    public static int HEALTH = 100;
    private int level = 1;
    private int score = 0;

    public void tick() {

        HEALTH = (int) Game.playerCollision(HEALTH, 0, 100);

        score++;

        if (HEALTH == 0) {

        }

    }

    public void render(Graphics graphics) {

//        graphics.setColor(Color.RED);
//        graphics.fillRect(15,15, 300, 15);
        graphics.setColor(Color.GREEN);
        graphics.fillRect(15, 15, HEALTH * 3, 15);
        graphics.setColor(Color.WHITE);
        graphics.drawRect(15, 15, 300, 15);
        graphics.setColor(Color.WHITE);
        graphics.fillRect(800, 0, 5, 900);

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
