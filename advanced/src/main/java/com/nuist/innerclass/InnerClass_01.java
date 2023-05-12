package com.nuist.innerclass;

public class InnerClass_01 {
    public static void main(String[] args) {

    }
}

/*
局部内部类
 */
class Outer01 {
    private int n1 = 100;

    private void m1() {
    }

    public void m2() {
        class Inner01 {//定义在外部类的 *方法或者代码块中* 且 *有名字* 叫做局部内部类。不可用修饰符修饰class除了final
            private int n1 = 10;//同名时就近原则，此时要访问外部类成员要使用 *外部类名.this.属性*

            public void m3() {
                System.out.println(n1);//局部内部类可以直接使用外部类属性和方法，包括private
                m1();
            }
        }
        Inner01 inner01 = new Inner01();//想使用局部内部类直接new对象就行
        inner01.m3();
    }
}
