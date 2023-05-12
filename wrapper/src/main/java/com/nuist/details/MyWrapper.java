package com.nuist.details;

public class MyWrapper {
    public static void main(String[] args) {
        Integer m = 1;
        Integer n = 1;
        System.out.println(m == n);//true，因为底层调用的是Integer.valueOf(1)，而这个包装类中定义-128到127之间的数是直接取的，所以是同一个对象

        Integer i = new Integer(1);
        Integer j = new Integer(1);
        System.out.println(i == j);//false，因为new肯定就不是一个对象了
    }
}
