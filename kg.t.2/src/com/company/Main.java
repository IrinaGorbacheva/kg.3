package com.company;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.lang.String;
import java.util.Scanner;
import javax.swing.*;

public class Main extends JPanel {
    public static void main(String[] args) {

        JFrame f = new JFrame();
        f.add(new Main());
        f.setSize(400, 400);
        f.setLocationRelativeTo(null);
        f.setVisible(true);


    }

    @Override
    protected void paintComponent(Graphics g) {
        DDA(g, 50, 50, 70, 150);
        Bresenhem2(g, 50, 50, 160, 160);
        By (g, 50, 50, 190, 300);
    }


    private void DDA(Graphics g, int x1, int y1, int x2, int y2) {

            int dx = x2 - x1;
            int dy = y2 - y1;
            double D = Math.max(Math.abs(dx), Math.abs(dy));
            double yY = (double) dy / D;
            double xX = (double) dx / D;
            for (int i = 0; i < D; i++) {
                g.drawRect(x1 + (int)(xX * i), y1 + (int)(yY * i), 1, 1);
            }
    }


    private void Bresenhem2(Graphics g, int x1, int y1, int x2, int y2){
        int dx = Math.abs(x2 - x1);
        int dy = Math.abs(y2 - y1);
        int sx = (x1 < x2) ? 1 : -1;
        int sy = (y1 < y2) ? 1 : -1;
        int err = dx - dy;
        while (true) {
            g.drawRect(x1, y1, 1, 1);
            if (x1 == x2 && y1 == y2) {
                break;
            }
            int e2 = 2 * err;
            if (e2 > -dy) {
                err = err - dy;
                x1 = x1 + sx;
            }
            if (e2 < dx) {
                err = err + dx;
                y1 = y1 + sy;
            }
        }

    }

    private void By (Graphics g, int x1, int y1, int x2, int y2) {
        //if (x2 < x1) {
        //    x1 += x2;
         //   x2 = x1 - x2;
         //   x1 -= x2;
         //   y1 += y2;
         //   y2 = y1 - y2;
         //   y1 -= y2;
       // }
        int dx = x2 - x1;
        int dy = y2 - y1;
        //Горизонтальные и вертикальные линии не нуждаются в сглаживании
        if (dx == 0 || dy == 0) {
            g.setColor(Color.BLACK);
            g.drawLine(x1, y1, x2, y2);
            return;
        }
        float gradient = 0;
        if (dx > dy) {
            gradient = (float) dy / dx;
            float intery = y1 + gradient;
            g.setColor(Color.BLACK);
            g.drawLine(x1, y1, x1, y1);
            for (int x = x1; x < x2; ++x) {
                g.setColor(new Color(0, 0, 0, (int) (255 - fractionalPart(intery) * 255))); //Меняем прозрачность
                g.drawLine(x, (int)intery, x, (int)intery);
                g.setColor(new Color(0, 0, 0, (int) (fractionalPart(intery) * 255)));
                g.drawLine(x, (int)intery + 1, x, (int)intery + 1);
                intery += gradient;
            }
            g.setColor(Color.BLACK);
            g.drawLine(x2, y2, x2, y2);
        }
        else {
            gradient = (float) dx / dy;
            float interx = x1 + gradient;
            g.setColor(Color.BLACK);
            g.drawLine(x1, y1, x1, y1);
            for (int y = y1; y < y2; ++y) {
                g.setColor(new Color(0, 0, 0, (int) (255 - fractionalPart(interx) * 255)));
                g.drawLine((int)interx, y, (int)interx, y);
                g.setColor(new Color(0, 0, 0, (int) (fractionalPart(interx) * 255)));
                g.drawLine((int)interx + 1, y, (int)interx + 1, y);
                interx += gradient;
            }
            g.setColor(Color.BLACK);
            g.drawLine(x2, y2, x2, y2);
        }
    }

    private float fractionalPart(float x) {
        int tmp = (int) x;
        return x - tmp; //вернёт дробную часть числа
    }

}

