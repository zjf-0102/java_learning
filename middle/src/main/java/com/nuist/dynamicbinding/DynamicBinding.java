package com.nuist.dynamicbinding;

/**
 * 动态绑定
 * 1、调用方法时，方法会和运行类型也就是内存中的地址绑定
 * 2、但在调用属性时，不会进行动态绑定
 */
public class DynamicBinding {
    public static void main(String[] args) {
        A a = new B();
        System.out.println(a.add());
    }
}

