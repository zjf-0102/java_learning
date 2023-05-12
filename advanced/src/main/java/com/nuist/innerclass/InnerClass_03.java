package com.nuist.innerclass;

public class InnerClass_03 {
    public static void main(String[] args) {

    }
}

/*
成员内部类
 */
class Outer03{
    private int n3 = 100;
    public void method(){}
    class Inner03{//是可以加修饰符的
        public void say(){
            System.out.println("细节和之前的局部内部类差不多");
        }
    }
}