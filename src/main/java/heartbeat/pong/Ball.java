package heartbeat.pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Ball extends GameObject {

    private Handler handler;

    public Ball(int x, int y, ID id, Handler handler) {

        super(x, y, id);

        this.handler = handler;

        spdX = (int) 0.7;
        spdY = (int) 0.7;


    }

    public Rectangle getBounds() {

        return new Rectangle((int) x, (int) y, 18, 18);

    }


    /**
     * Makes the ball rebound when hitting the borders
     */
    public void tick() {
        y += spdY;
        x += spdX;

        if (y <= 0 || y >= Game.HEIGHT - 9) {
            spdY *= -1;
        }

        if (x <= 0 || x >= Game.WIDTH - 9) {
            spdX *= -1;
        }

        collision();

    }

    public void collision() {
        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);

            if (tempObject.getId() == ID.Player || tempObject.getId() == ID.Enemy) {
                if (getBounds().intersects(tempObject.getBounds())) {
                    spdX *= -1;
                }
            }

        }

        handler
            .addObject(new Trail((int) x, (int) y, ID.Trail, Color.WHITE, 18, 18, 0.009f, handler));
    }

    public void render(Graphics graphics) {

        graphics.setColor(Color.WHITE);
        graphics.fillRect((int) x, (int) y, 18, 18);

    }


}
