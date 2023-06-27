package com.nuist.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nuist.mybatisplus.mapper.UserMapper;
import com.nuist.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MybatisplusApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test01() {
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

    @Test
    public void testWrapper(){
        List<User> users = userMapper.selectList(new QueryWrapper<User>().like("username","a").between("age",15,30).isNotNull("email"));
        users.forEach(System.out::println);
    }

    @Test
    public void testPage(){
        Page<User> userPage = new Page<>(2,3);
        //如果自己写的方法想要实现分页功能，就需要保证接口中的第一个形参是Page类型
        userMapper.selectPage(userPage,null);
        System.out.println(userPage);
    }

}
