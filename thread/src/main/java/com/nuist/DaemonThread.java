package com.nuist;

public class DaemonThread { //守护线程
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new DaemonThreadTest());
        //将线程设置为守护线程，所有用户线程结束后该线程也结束
        thread.setDaemon(true);
        thread.start();

        for (int i = 0; i < 10; i++) {
            System.out.println("主线程在运行...");
            Thread.sleep(1000);
        }


    }
}

class DaemonThreadTest implements Runnable{

    @Override
    public void run() {
        for ( ; ; ){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"正在运行...");
        }
    }
}