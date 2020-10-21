package com.company;

import java.awt.*;

public class Grid implements Drawable{
    @Override
    public void draw(Graphics2D g) {
        grid(g);
    }

    public static void grid(Graphics2D g) {
        int x1 = 0;
        int x2 = 0;
        int y1 = 0;
        int y2 = 600;
        for (int i = 0; i < 32; i++) {
            x1 += 25;
            x2 += 25;
            g.setColor(Color.blue);
            g.drawLine(x1, y1, x2, y2);
        }
        x1 = 0;
        x2 = 800;
        y1 = 0;
        y2 = 0;
        for (int j = 0; j < 24; j++) {
            y1 += 25;
            y2 += 25;
            g.drawLine(x1, y1, x2, y2);
        }

    }
}
