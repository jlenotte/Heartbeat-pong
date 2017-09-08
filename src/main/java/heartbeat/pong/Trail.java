package heartbeat.pong;

import java.awt.*;

/**
 * Created by Jules on 07/05/2017.
 */

public class Trail extends GameObject {

    private float alpha = 1;
    private float life;
    private Handler handler;
    private Color color;
    private int width, height;

    // life = de 0.01 à 0.1

    public Trail(int x, int y, ID id, Color color, int width, int height, float life,
        Handler handler) {

        super(x, y, id);
        this.handler = handler;
        this.color = color;
        this.color = color;
        this.width = width;
        this.height = height;
        this.life = life;

    }

    public void tick() {

        if (alpha > life) {

            alpha -= (life - 0.0001f);

        }

        else {
            handler.removeObject(this);
        }

    }

    public void render(Graphics graphics) {

        Graphics2D g2d = (Graphics2D) graphics;

        g2d.setComposite(makeTransparent(alpha));
        graphics.setColor(color);
        graphics.fillRect((int) x, (int) y, width, height);

        g2d.setComposite(makeTransparent(1));


    }

    private AlphaComposite makeTransparent(float alpha) {

        int type = AlphaComposite.SRC_OVER;
        return AlphaComposite.getInstance(type, alpha);

    }

    public Rectangle getBounds() {

        return null;

    }
}
