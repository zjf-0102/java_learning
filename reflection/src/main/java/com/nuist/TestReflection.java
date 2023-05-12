package com.nuist;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * 反射和类加载过程
 */
public class TestReflection {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {

        //先读取配置文件
        Properties properties = new Properties();
        properties.load(TestReflection.class.getClassLoader().getResourceAsStream("reflection.properties"));
        String classname = properties.getProperty("classname");
        String method = properties.getProperty("method");

        //反射得到类对象
        Class<?> cls = Class.forName(classname);
        //通过类对象得到方法对象
        Method mtd = cls.getMethod(method);
        //调用方法创建对象实例
        Object o = cls.newInstance();
        //让对象实例调用方法
        mtd.invoke(o);

    }

}

/*
        类加载分为三步
        1、加载
            将.class文件读入到方法区中，同时在堆中创建一个对应的Class类
        2、连接(验证，准备，解析)
            将类的二进制数据合并到JRE中
            1）验证：验证文件是否会对JVM产生危害
            2）准备：对静态变量分配空间，static会赋默认值，static final会直接赋值
            3）解析：将常量池的符号引用替换为直接引用
        3、初始化
            主要是指静态成员的初始化static
 */
