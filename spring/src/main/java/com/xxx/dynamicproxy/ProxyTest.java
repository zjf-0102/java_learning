package com.xxx.dynamicproxy;

import com.xxx.dao.UserDao;
import com.xxx.dao.UserDaoImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/*
动态代理的底层实现方式
 */
public class ProxyTest {

    public static void main(String[] args) {
        //以增强UserDao中的方法为例
        //首先需要创建一个动态代理对象，由他来完成对原方法的增强
        Class[] interfaces = new Class[]{UserDao.class};
        UserDao ud = (UserDao)Proxy.newProxyInstance(ProxyTest.class.getClassLoader(), interfaces, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //在这里面来实现具体的增强
                System.out.println("方法执行前干的事儿。。。。");
                Object res = method.invoke(new UserDaoImpl(), args);
                System.out.println("方法执行后干的事儿。。。。");
                return res;
            }
        });

        ud.testDao();

    }

}
