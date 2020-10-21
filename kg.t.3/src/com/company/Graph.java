package com.company;

import java.awt.*;

public class Graph implements Drawable{
    @Override
    public void draw(Graphics2D g) {
        simpleGraph(g);
    }

    public static void simpleGraph(Graphics2D g){
        g.setColor(Color.BLACK);
        g.drawRect(0,350, 800, 1);
        g.drawRect(350,0, 1, 600);

        int text = -14;
        int x1 = 3;
        int x2 = 0;
        for (int i = 0; i < 30; i++) {
            text += 1;
            x1 += 25;
            x2 += 25;
            g.drawLine(x2, 360, x2, 340);
            g.drawString(String.valueOf(text), x1, 365);
        }
        text = -10;
        int y1 = 598;
        int y2 = 600;
        for (int j = 0; j < 22; j++) {
            text += 1;
            y1 -= 25;
            y2 -= 25;
            g.drawLine(360, y2, 340, y2);
            g.drawString(String.valueOf(text), 334, y1);
        }

        g.drawString(">",775, 356);
        g.drawString("^",349, 20);
        g.drawString("X",775, 365);
        g.drawString("Y",340, 20);


        int step = 25;


        for (int x = -10; x <= 20; x ++) {

            g.drawLine((x * 25 +350), (int)f(x), ((x + 1) * 25 + 350), (int)f(x + 1));
        }

    }

    public static double f(int x) {
        Input in = new Input();
        //in.simpleInput("Введите а");
        int a = 1;
        int b = 1;
        int c = 1;
        int d = 5;
        int e = 5;
        /*double a = -0.5;
        double b = -0.5;
        double c = -0.5;
        double d = -0.5;
        double e = 0;*/
        return ((a * Math.pow(x, 4) + b * Math.pow(x, 3) + c * Math.pow(x, 2) + d * x + e) * (-25) + 350);
    }
}
