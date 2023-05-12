package com.nuist.dynamicbinding;

class A {
    private int value = 10;

    public int add() {
        //由于B中没有add方法，所以运行时会调用此add方法
        return getValue() + value;//这里的getValue方法因为“动态绑定”运行时调用的是B类中的getValue方法；后面的value因为是属性所以没有“动态绑定”直接调用A类中的属性值
    }

    public int getValue() {
        return value;
    }
}
