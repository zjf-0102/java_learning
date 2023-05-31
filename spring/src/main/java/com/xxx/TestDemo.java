package com.xxx;

import com.xxx.service.UserService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDemo {

    public static void main(String[] args) {
        //Spring提供了两种IOC容器的实现方式   BeanFactory 和 ApplicationContext
        //BeanFactory一般不使用，是Spring内部使用的接口
        // 不同：读取配置文件时不会创建对象
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        User user = context.getBean("user", User.class);
        System.out.println(user);
        user.say();
    }

    @Test
    public void test01(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        UserService userService = context.getBean("userService", UserService.class);
        userService.test();
    }

}
