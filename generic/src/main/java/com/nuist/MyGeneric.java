package com.nuist;

/**
 * 泛型: 用来表示一种数据类型
 */
public class MyGeneric {
    public static void main(String[] args) {

        class Person<E> {
            E e;

            //泛型的数组不能初始化，因为不知道大小；也不能在静态方法中使用
            //E[] es = new E[8];

            public Person(E e) {
                this.e = e;
            }

            public E f() {
                return e;
            }
        }

        Person<String> stringPerson = new Person<>("hello");

    }
}
