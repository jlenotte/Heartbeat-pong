package heartbeat.pong;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by Jules on 07/05/2017.
 */
public class KeyInput extends KeyAdapter {

  private Handler handler;
  private boolean[] keyDown = new boolean[4];

  public KeyInput(Handler handler) {

    this.handler = handler;

  }

  public void keyPressed(KeyEvent keyEvent) {

    int key = keyEvent.getKeyCode();

    for (int i = 0; i < handler.object.size(); i++) {

      GameObject tempObject = handler.object.get(i);

      if (tempObject.getId() == ID.Player) {

        if (key == KeyEvent.VK_Z) {
          tempObject.setSpdY((float) -1);
          keyDown[0] = true;
        }
        if (key == KeyEvent.VK_S) {
          tempObject.setSpdY(1);
          keyDown[1] = true;
        }

      }

    }

  }

  public void keyReleased(KeyEvent keyEvent) {

    int key = keyEvent.getKeyCode();

    for (int i = 0; i < handler.object.size(); i++) {

      GameObject tempObject = handler.object.get(i);

      if (tempObject.getId() == ID.Player) {

        if (key == KeyEvent.VK_Z) {
          keyDown[0] = false;
        }
        if (key == KeyEvent.VK_S) {
          keyDown[1] = false;
        }

        //vertical movement
        if (!keyDown[0] && !keyDown[1]) {
          tempObject.setSpdY(0);
        }

      }

    }

    if (key == KeyEvent.VK_ESCAPE) {
      System.exit(1);
    }

  }
}
