package com.nuist.finaldetails;

/**
 * final关键词
 * 类：无法被继承
 * 方法：无法被重写
 * 属性，变量：无法被修改
 */
public class Final {
    /*
    final 和 static 一起使用时不会造成类加载，优化了效率
     */
    public static final int x = 100;//在调用Final.x时不会类加载
}
