package com.nuist.polymethod;

/**
 * 重载和重写都是方法的多态的体现
 * ！！！！！！！！！！！属性没有重写
 * 例如：Base base = new Sub()
 * base.count获取的是base中的count值，看的是编译类型
 */
public class PolyMethod {
    public static void main(String[] args) {
        Parent parent = new Son();
        parent.say();
    }
}