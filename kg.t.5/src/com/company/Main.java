/*3. Написать программу управления перемещением рисованного объекта клавиатурой.*/
/*Перемещение с помощью клавиш вверх, вниз, влево, вправо.*/
package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;

public class Main extends JComponent implements KeyListener, ActionListener {

    Timer time = new Timer(0, this);
    Rectangle rectangle = new Rectangle(50, 50, 75, 95);

    public static void main(String[] args) {
        Main main = new Main();
	    JFrame f = new JFrame();
	    f.setSize(600, 600);
        f.setLocationRelativeTo(null);
	    f.setVisible(true);
	    f.add(main);
	    f.addKeyListener(main);
    }

    public void paint(Graphics g){
        time.start();
        Graphics2D g1 =  (Graphics2D)g;
        g1.setStroke(new BasicStroke(10));
        g1.setColor(Color.red);
        g1.draw(rectangle);
        g1.setColor(Color.pink);
        g1.fill(rectangle);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT){
            rectangle.setLocation(rectangle.x+1, rectangle.y);
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            rectangle.setLocation(rectangle.x - 1, rectangle.y);
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN){
            rectangle.setLocation(rectangle.x, rectangle.y+1);
        }
        if (e.getKeyCode() == KeyEvent.VK_UP){
            rectangle.setLocation(rectangle.x, rectangle.y-1);
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
