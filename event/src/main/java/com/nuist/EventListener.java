package com.nuist;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class EventListener implements KeyListener {
    public static void main(String[] args) {
        //可以让MyPanel继承这个接口监听键盘，这里程序运行一下就关了没法试
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println(e.getKeyChar() + "被按下");
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
