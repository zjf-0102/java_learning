package com.nusit;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nuist.mapper.ClassMapper;
import com.nuist.mapper.UserMapper;
import com.nuist.mapper.UserNewMapper;
import com.nuist.pojo.Class;
import com.nuist.pojo.User;
import com.nuist.pojo.UserNew;
import com.nuist.pojo.UserNewExample;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisTest {

    @Test
    public void test01() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSession sqlSession = new SqlSessionFactoryBuilder().build(is).openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User(null, "老六", "126", 12, "女", "asd@qq.com");
        int i = mapper.insertUser(user);
//        sqlSession.commit();
        System.out.println(i);
        System.out.println(user);
    }

    @Test
    public void test02() throws IOException {
        SqlSession sqlSession = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml")).openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.selectUserById(1);
        System.out.println(user);
    }

    @Test
    public void test03() throws IOException {
        SqlSession sqlSession = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml")).openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.checkLogin("admin", "123456");
        System.out.println(user);
    }

    @Test
    public void test04() throws IOException {
        SqlSession sqlSession = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml")).openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.selectByParam("admin", "123456");
        users.forEach(System.out::println);
    }

    @Test
    public void test05() throws IOException {
        SqlSession sqlSession = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml")).openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.selectByLike("a");
        users.forEach(System.out::println);
    }

    @Test
    public void test06() throws IOException {
        SqlSession sqlSession = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml")).openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int i = mapper.deleteMore("1,2");
        System.out.println(i);
    }

    @Test
    public void test07() throws IOException {
        SqlSession sqlSession = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml")).openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.selectDetailUser(3);
        System.out.println(user);
    }

    @Test
    public void test08() throws IOException {
        SqlSession sqlSession = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml")).openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.selectByStep(3);
        System.out.println(user);
    }

    @Test
    public void test09() throws IOException {
        SqlSession sqlSession = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml")).openSession(true);
        ClassMapper mapper = sqlSession.getMapper(ClassMapper.class);
        Class room = mapper.selectDetailClass(2);
        System.out.println(room);
    }

    @Test
    public void test10() throws IOException {
        SqlSession sqlSession = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml")).openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.selectByCondition(new User(null, "张三", "123456", 12, null, null));
        users.forEach(System.out::println);
    }

//    测试逆向工程生成的代码如何使用
    @Test
    public void test11() throws IOException {
        SqlSession sqlSession = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml")).openSession(true);
        UserNewMapper mapper = sqlSession.getMapper(UserNewMapper.class);
        UserNewExample userNewExample = new UserNewExample();
        userNewExample.createCriteria().andAgeBetween(10,20).andPasswordLike("%3%");
        List<UserNew> userNews = mapper.selectByExample(userNewExample);
        userNews.forEach(System.out::println);
    }

    //    测试分页插件
    @Test
    public void test12() throws IOException {
        SqlSession sqlSession = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml")).openSession(true);
        UserNewMapper mapper = sqlSession.getMapper(UserNewMapper.class);


        PageHelper.startPage(2,3);
        List<UserNew> userNews = mapper.selectByExample(null);
//        把查出来的所有数据放到pageInfo里可以得到所需要的各种参数
        PageInfo<UserNew> pageInfo = new PageInfo<>(userNews,3);


        userNews.forEach(System.out::println);
        System.out.println(pageInfo);
    }

}
