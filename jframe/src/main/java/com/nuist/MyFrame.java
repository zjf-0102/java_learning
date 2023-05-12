package com.nuist;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("all")
public class MyFrame extends JFrame {
    private MyPanel myPanel;

    public MyFrame() {
        myPanel = new MyPanel();
        this.add(myPanel);
        this.setSize(500, 500);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new MyFrame();
    }
}

class MyPanel extends JPanel {
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawOval(10, 10, 100, 100);
    }
}