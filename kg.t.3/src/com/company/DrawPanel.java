package com.company;

import javax.swing.*;
import java.awt.*;


public class DrawPanel extends JPanel {
    private Grid grid = new Grid();
    private Graph graph = new Graph();



    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D gr = (Graphics2D) g;
        grid.draw(gr);
        graph.draw(gr);

    }
}
