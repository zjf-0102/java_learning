package com.nuist.interfacedetails;

/**
 * jdk7.0以前接口中只能有抽象方法
 * jdk8.0以后可以有静态方法，默认方法，即可以有方法的具体实现
 */
public interface MyInterface {
    int num = 0;

    void hi();

    default void defaultMethod() {
        System.out.println("默认方法");
    }

    static void staticMethod() {
        System.out.println("静态方法");
    }
}

//如果一个类同时继承父类和实现接口，并且两个同共同的属性x，那么子类在调用这个属性x时要么  super.x  要么  接口名.x
class TestMyInterface implements MyInterface{

    @Override
    public void hi() {
        System.out.println("实现接口方法");
    }

}