package com.nuist.classloader;

public class A {
    {
        System.out.println("非静态代码块被调用");
    }

    private int ii = getValue2();


    private static int i = getValue();

    static {
        System.out.println("静态代码块被调用");
    }

    public static int getValue() {
        System.out.println("静态属性被初始化");
        return 1;
    }

    public int getValue2() {
        System.out.println("非静态属性被初始化");
        return 2;
    }

    public A() {
        System.out.println("构造器被调用");
    }
}
