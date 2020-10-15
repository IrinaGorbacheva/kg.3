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
        drawSquare(g);
    }



    private void drawSquare(Graphics g) {
        g.drawLine(10, 0, 100, 100);
        g.drawRect(0, 0, 50, 50);
        g.drawOval(50, 50, 100, 100);
        Point aPoint = new Point(10, 10);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.blue);
        g2d.setStroke(new BasicStroke(6));
        Rectangle2D rect = new Rectangle2D.Double(10, 10, 90, 90);
        g2d.draw(rect);
        g2d.fill(rect);
        g2d.setColor(Color.orange);
        g2d.setStroke(new BasicStroke(2));
        Ellipse2D circle = new Ellipse2D.Double(250, 225, 120,120);
        g2d.draw(circle);

    }

}