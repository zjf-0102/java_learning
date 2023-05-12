package com.nuist;

public class Cpu {
    public static void main(String[] args) {

        Runtime runtime = Runtime.getRuntime();
        System.out.println(runtime.availableProcessors());

    }
}
