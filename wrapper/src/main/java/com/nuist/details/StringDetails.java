package com.nuist.details;

public class StringDetails {
    public static void main(String[] args) {
        //String类中存值的时候其实是一个final的char数组，这里的final指的是指向不能改变，而不是值不能改变
        final char[] value = {'a', 'b', 'c'};
        char[] value2 = {'1', '2', '3'};
        value[0] = 'x';//这个改值没问题
        //value = value2;//这个改指向不允许


        String s1 = "abc";//直接去常量池找，有就指，没有创了再指                                他最后指向常量池
        String s2 = new String("abc");//先创个对象，对象中的属性value和上面一个道理     他最后指向堆中的对象，对象中的value指向常量池


        String a = "abc";
        String b = "qwe";
        String c = a + b;//底层是调用StringBuilder来append的，所以最终c指向堆中的一个对象
        String d = "abc" + "qwe";//底层优化成String d = "abcqwe";如果没有前面的a和b的话，常量池中只会新增"abcqwe"
    }
}
