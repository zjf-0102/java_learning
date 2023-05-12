package com.nuist.biginteger;

import java.math.BigDecimal;

public class MyBigDecimal {
    public static void main(String[] args) {
        //保存高精度的值
        BigDecimal bigDecimal = new BigDecimal("123.456789123456789");
        //add subtract multiply divide  这里除法要注意一下可能除不尽
        //这个2代表的是BigDecimal.ROUND_CEILING,用来指定结果的精度，也可以有其他选择
        System.out.println(bigDecimal.divide(new BigDecimal("123.324"),2));
    }
}
