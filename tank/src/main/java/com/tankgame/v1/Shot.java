package com.tankgame.v1;

public class Shot implements Runnable {

    private int x;
    private int y;
    private int direction = 0;
    private int speed = 2;
    private boolean isAlive = true;

    public Shot(int x, int y, int direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            switch (direction) {
                case 0://上
                    y -= speed;
                    break;
                case 3://右
                    x += speed;
                    break;
                case 1://下
                    y += speed;
                    break;
                case 2://左
                    x -= speed;
                    break;
            }

            if (!(x >= 0 && x <= 1000 && y >= 0 && y <= 750)) {
                isAlive = false;
                break;
            }

        }
    }
}
