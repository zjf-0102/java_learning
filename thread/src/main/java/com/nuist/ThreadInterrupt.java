package com.nuist;


/**
 * 线程的一些概念
 *
 * 七个状态：new，ready，running，blocked，waiting，timedwaiting，terminated
 *
 *          new：新建一个线程对象时线程的状态
 *          ready：可以被选中执行
 *          running：被选中执行     此时yield()会回到ready
 *          blocked：阻塞，等待锁
 *          waiting：调用对象的wait()或者在该线程中调用其他线程的join()会进入到该状态，释放锁    唤醒方式：调用对象的notify(),notifyAll()
 *          timedwaiting：有时间限制的等待，如sleep(time)，wait(time)等
 *          terminated：线程结束
 *
 */

public class ThreadInterrupt {
    public static void main(String[] args) {
        Thread thread = new Thread(new T());
        thread.setPriority(Thread.MIN_PRIORITY);
        thread.setName("线程1");
        thread.start();

        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("主线程过去了" + i + "秒");
        }

        thread.interrupt();//执行到这里，thread原本在休眠，但是被中断了，又重新开始运行
    }
}

class T implements Runnable {

    @Override
    public void run() {
        while (true) {
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + "正在吃饭···" + i);
            }
            try {
                System.out.println(Thread.currentThread().getName() + "吃饱了···");
                Thread.sleep(20 * 1000);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + "捕获到中断异常");
            }
        }
    }
}