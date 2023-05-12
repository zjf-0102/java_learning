package com.nuist.codeblock;

public class Movie {
    private String name;
    private double price;
    private String director;

    {
        System.out.println("代码块在每次创建对象时都会被调用!");
        System.out.println("先调用代码块再调用构造器中的语句!");
    }

    public Movie(String name) {
        this.name = name;
    }

    public Movie(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public Movie(String name, double price, String director) {
        this.name = name;
        this.price = price;
        this.director = director;
    }
}
