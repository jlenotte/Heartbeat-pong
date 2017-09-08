package heartbeat.pong;

import java.util.Random;

/**
 * Created by Jules on 18/05/2017.
 */

public class Spawn {

    private Handler handler;
    private HUD hud;
    private Random rndm = new Random();
    private int scoreCount = 0;

    public Spawn(Handler handler, HUD hud) {

        this.handler = handler;
        this.hud = hud;

    }

    public void tick() {

        scoreCount++;

        if (scoreCount >= 1000) {

            scoreCount = 0;
            hud.setLevel(hud.getLevel() + 1);

        }

        if (hud.HEALTH == 0) {

        }

    }

}
