package heartbeat.pong;

import java.util.Random;

/**
 * Created by Jules on 18/05/2017.
 */

public class Spawn {

  public static int score;
  private Handler handler;
  private HUD hud;
  private Random rndm = new Random();
  private GameObject ball;
  public static int scoreCount = 0;

  public Spawn(Handler handler, HUD hud) {

    this.handler = handler;
    this.hud = hud;

  }

  public void tick() {


  }

}
