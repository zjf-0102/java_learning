package com.nuist.codeblock;

public class StaticMovie {
    private String name;
    private double price;
    private String director;

    static {
        System.out.println("静态代码块在类加载的时候被调用!并且只调用一次！！！");
    }

}
