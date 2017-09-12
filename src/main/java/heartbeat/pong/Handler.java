package heartbeat.pong;

import java.awt.*;
import java.util.LinkedList;

/**
 * Created by Jules on 07/05/2017.
 */

// Will maintain, update, render all of our objects

public class Handler {

    LinkedList<GameObject> object = new LinkedList<GameObject>();

    public void tick() {

        for (int i = 0; i < object.size(); i++) {

            assert (object.size() > 0);
            GameObject tempObject = object.get(i);
            tempObject.tick();

        }

    }

    public void render(Graphics graphics) {

        for (int i = 0; i < object.size(); i++) {

            GameObject tempObject = object.get(i);
            tempObject.render(graphics);

        }

    }

    public void addObject(GameObject object) {

        this.object.add(object);

    }

    public void removeObject(GameObject object) {

        this.object.remove(object);

    }

    public void clearEnemies() {

        for (int i = 0; i < object.size(); i++) {

            GameObject tempObject = object.get(i);
            if (tempObject.getId() == ID.Player) {

                object.clear();

            }

            addObject(
                new Player((int) tempObject.getX(), (int) tempObject.getY(), ID.Player, this));
            addObject(
                new Player((int) tempObject.getX(), (int) tempObject.getY(), ID.Player, this));

        }

    }
}