package com.nuist.innerclass;

public class InnerClass_02 {
    public static void main(String[] args) {

    }
}

/*
匿名内部类
 */
class Outer02 {
    private int n2 = 100;

    public void method() {
        //基于接口的匿名内部类(底层其实创建了Outer02$1实现了接口IA)
        IA test01 = new IA() {
            @Override
            public void cry() {
                System.out.println("在new接口的同时把其中的方法实现了");
            }
        };

        //基于类的匿名内部类(底层其实创建了Outer02$2继承了父类Father)
        Father test02 = new Father("jack") {
            @Override
            public void test() {
                System.out.println("这里可以重写父类的方法");
            }
        };
    }
}

interface IA {
    void cry();
}

class Father {
    public Father(String name) {

    }

    public void test() {

    }
}