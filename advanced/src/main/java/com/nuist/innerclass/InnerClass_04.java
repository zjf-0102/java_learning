package com.nuist.innerclass;

public class InnerClass_04 {
    public static void main(String[] args) {
        new Outer04.Inner04();
    }
}

/*
静态内部类
 */
class Outer04 {
    private int n4 = 100;
    private static int n5 = 10;

    public void method() {
    }

    public static class Inner04 {//加了个静态修饰符，只可以访问外部类中的静态属性

        public void say() {
            System.out.println("细节和之前的局部内部类差不多" + n5);
        }
    }
}