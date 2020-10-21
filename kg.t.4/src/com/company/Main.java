package com.company;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.lang.String;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;

public class Main extends JPanel {
    public static void main(String[] args) {

        JFrame f = new JFrame();
        f.add(new Main());
        f.setSize(600, 600);
        f.setLocationRelativeTo(null);
        f.setVisible(true);


    }

    @Override
    protected void paintComponent(Graphics g) {
        B3(g, 200, 30, 20, 50, 70, 20);
        B4(g, 100, 400, 60, 200, 300, 250, 400, 350);
    }


    private void B3 (Graphics g, int x1, int y1, int x2, int y2, int x3, int y3){
        Point p1 = new Point(x1, y1);
        g.drawRect(p1.x, p1.y, 1, 1);
        Point p2 = new Point(x2, y2);
        g.drawRect(p2.x, p2.y, 1, 1);
        Point p3 = new Point(x3, y3);
        g.drawRect(p3.x, p3.y, 1, 1);
        double x,y;
        int x11 = p1.x;
        int y11 = p1.y;
        for (double t = 0; t <= 1; t+=0.1 ) {
            x = p1.x * Math.pow(1 - t, 2) + 2 * p2.x * t * (1 - t) + t * t * p3.x;
            y = p1.y * Math.pow(1 - t, 2) + 2 * p2.y * t * (1 - t) + t * t * p3.y;
            g.drawLine(x11, y11, (int) Math.round(x), (int) Math.round(y));
            x11 = (int) Math.round(x);
            y11 = (int) Math.round(y);
        }
    }

    private void B4 (Graphics g, int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4){
        g.setColor(Color.RED);
        Point p1 = new Point(x1, y1);
        g.drawRect(p1.x, p1.y, 1, 1);
        Point p2 = new Point(x2, y2);
        g.drawRect(p2.x, p2.y, 1, 1);
        Point p3 = new Point(x3, y3);
        g.drawRect(p3.x, p3.y, 1, 1);
        Point p4 = new Point(x4, y4);
        g.drawRect(p4.x, p4.y, 1, 1);
        double x,y;
        int x11 = p1.x;
        int y11 = p1.y;
        for (double t = 0; t <= 1; t+=0.1 ) {
            x = p1.x*(Math.pow(-t,3)+3*Math.pow(t,2)-3*t+1)
                    +3*p2.x*t*(Math.pow(t,2)-2*t+1)
                    +3*p3.x*Math.pow(t,2)*(1-t)+p4.x*Math.pow(t,3);
            y = p1.y*(Math.pow(-t,3)+3*Math.pow(t,2)-3*t+1)
                    +3*p2.y*t*(Math.pow(t,2)-2*t+1)
                    +3*p3.y*Math.pow(t,2)*(1-t)+p4.y*Math.pow(t,3);
            g.drawLine(x11, y11, (int) Math.round(x), (int) Math.round(y));
            x11 = (int) Math.round(x);
            y11 = (int) Math.round(y);
        }
    }
}