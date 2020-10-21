package com.company;

import javax.swing.*;
import java.awt.*;

class MainWindow extends JFrame {
    public MainWindow() throws HeadlessException {
        DrawPanel dp = new DrawPanel();
        this.add(dp);

    }
}
