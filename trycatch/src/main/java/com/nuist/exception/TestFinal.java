package com.nuist.exception;

public class TestFinal {
    public static int method() {
        int i = 1;
        try {
            i++;
            String[] str = new String[3];
            if (str[1].equals("tom"))//发生异常
                i++;
            else
                i--;
            return i;
        } catch (NullPointerException e) {//捕获，但因为有final，return不会立刻执行，先执行final中的代码
            return ++i;//最后会return，并且返回值依然是3
        } finally {
            i++;
            System.out.println("i=" + i);//这里执行完输出i=4
        }
    }

    public static void main(String[] args) {
        System.out.println(method());
    }
}
