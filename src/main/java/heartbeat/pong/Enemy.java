package heartbeat.pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Enemy extends GameObject {

    private Handler handler;
    private GameObject ball;
    private static final Logger LOG = LoggerFactory.getLogger(Enemy.class);

    public Enemy(int x, int y, ID id, Handler handler) {

        super(x, y, id);
        this.handler = handler;

        for (int i = 0; i < handler.object.size(); i++) {

            if (handler.object.get(i).getId() == ID.Ball) {
                ball = handler.object.get(i);
            }

        }
    }

    public Rectangle getBounds() {

        return new Rectangle((int) x, (int) y, 18, 68);

    }

    public void tick() {

        if (ball == null) {
            LOG.error("An error occured, {} cannot be null.", ball);
        }

        assert(x != 0);
        assert(y != 0);

        x += spdX;
        y += spdY;

        float diffX = x - ball.getX() - 9;
        float diffY = y - ball.getY() - 9;
        float distance = (float) Math
            .sqrt((x - ball.getX()) * (x - ball.getX()) + (y - ball.getY()) * (y - ball.getY()));

        spdX = (int) ((-0.3 / distance) * diffX);
        spdY = (int) ((-0.3 / distance) * diffY);

        if (y <= 0 || y >= Game.HEIGHT - 68) {
            spdY *= -1;
        }
        if (x <= 0 || x >= Game.WIDTH - 18) {
            spdX *= -1;
        }

    }

    public void render(Graphics graphics) {

        graphics.setColor(Color.WHITE);
        graphics.drawRect((int) x, (int) y, 18, 68);

    }
}
