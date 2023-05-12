package com.tankgame.v1;

import javax.swing.*;

public class MyFrame extends JFrame {
    MyPanel myPanel = null;

    public MyFrame() {
        myPanel = new MyPanel();
        new Thread(myPanel).start();
        this.add(myPanel);
        this.addKeyListener(myPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 750);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new MyFrame();
    }
}
