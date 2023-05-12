package com.tankgame.v1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

//游戏绘图区
public class MyPanel extends JPanel implements KeyListener,Runnable {
    MyTank myTank = null;
    Vector<Enemy> enemies = new Vector<>();
    private int enemySize = 3;

    public MyPanel() {
        myTank = new MyTank(100, 100);
        myTank.setSpeed(2);
        for (int i = 0; i < enemySize; i++) {
            Enemy enemy = new Enemy(100 * (i + 1), 0);
            enemy.setDirection(1);
            enemies.add(enemy);
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1000, 750);

        drawTank(myTank.getX(), myTank.getY(), g, myTank.getDirection(), 0);

        if (myTank.getShot() != null && myTank.getShot().isAlive()) {
            g.fill3DRect(myTank.getShot().getX(), myTank.getShot().getY(), 4, 4, false);
        }

        for (Enemy enemy : enemies) {
            drawTank(enemy.getX(), enemy.getY(), g, enemy.getDirection(), 1);
        }
    }

    /**
     * @param x         坦克左上角x轴位置
     * @param y         坦克左上角y轴位置
     * @param g         画笔
     * @param direction 方向
     * @param type      类型
     */
    public void drawTank(int x, int y, Graphics g, int direction, int type) {

        //判断类型，设置不同的颜色
        switch (type) {
            case 0://自己坦克
                g.setColor(Color.cyan);
                break;
            case 1://敌人坦克
                g.setColor(Color.yellow);
                break;

        }

        //判断方向，画坦克
        switch (direction) {
            case 0://向上
                g.fill3DRect(x, y, 10, 60, false);
                g.fill3DRect(x + 30, y, 10, 60, false);
                g.fill3DRect(x + 10, y + 10, 20, 40, false);
                g.fillOval(x + 10, y + 20, 20, 20);
                g.drawLine(x + 20, y - 10, x + 20, y + 30);
                break;
            case 1://向下
                g.fill3DRect(x, y, 10, 60, false);
                g.fill3DRect(x + 30, y, 10, 60, false);
                g.fill3DRect(x + 10, y + 10, 20, 40, false);
                g.fillOval(x + 10, y + 20, 20, 20);
                g.drawLine(x + 20, y + 70, x + 20, y + 30);
                break;
            case 2://向左
                g.fill3DRect(x, y, 60, 10, false);
                g.fill3DRect(x, y + 30, 60, 10, false);
                g.fill3DRect(x + 10, y + 10, 40, 20, false);
                g.fillOval(x + 20, y + 10, 20, 20);
                g.drawLine(x + 30, y + 20, x - 10, y + 20);
                break;
            case 3://向右
                g.fill3DRect(x, y, 60, 10, false);
                g.fill3DRect(x, y + 30, 60, 10, false);
                g.fill3DRect(x + 10, y + 10, 40, 20, false);
                g.fillOval(x + 20, y + 10, 20, 20);
                g.drawLine(x + 30, y + 20, x + 70, y + 20);
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            myTank.setDirection(0);
            myTank.moveUp();
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            myTank.setDirection(2);
            myTank.moveLeft();
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            myTank.setDirection(1);
            myTank.moveDown();
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            myTank.setDirection(3);
            myTank.moveRight();
        } else if (e.getKeyCode() == KeyEvent.VK_J) {
            myTank.shotEnemy();
        }

        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {

        while (true){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            this.repaint();
        }
    }

}
