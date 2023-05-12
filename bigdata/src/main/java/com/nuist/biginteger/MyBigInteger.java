package com.nuist.biginteger;

import java.math.BigInteger;

public class MyBigInteger {
    public static void main(String[] args) {
        //处理特别大的数,long也没法搞的数
        BigInteger bigInteger = new BigInteger("123456789123456789123456789");
        //加减乘除都是调方法
        System.out.println(bigInteger.add(new BigInteger("1")));
    }
}
