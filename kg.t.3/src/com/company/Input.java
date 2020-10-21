package com.company;

import javax.swing.*;

public class Input {
    public static int simpleInput(String text){

        int m = Integer.parseInt(JOptionPane.showInputDialog(text));
        return m;
    }
}
