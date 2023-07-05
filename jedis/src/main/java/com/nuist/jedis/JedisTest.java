package com.nuist.jedis;

import redis.clients.jedis.Jedis;

import java.util.Random;

public class JedisTest {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("主机地址",6379);
        //方法和命令行一样

        //模拟验证码
        //1、生成随机的六位数
        String code = "";
        for (int i = 0; i < 6; i++) {
            code += new Random().nextInt(10);
        }

        //2、将发送验证码的手机号存到redis里，保证他一天只能发三次
        String phone = "18851962075";
        jedis.setex(phone+"count",24*60*60,"0");
        //没发送一次，value值加1，直到加到3，不在允许该号码发送
        jedis.incr(phone+"count");

        //3、将正确的验证码存到redis中，时限2分钟
        jedis.setex(phone+"code",2*60,code);

        //4、接收到发送的验证码后进行验证
        String sCode = "这里是用户发送过来的验证码";
        if (sCode.equals(code))
            System.out.println("验证通过");
        else
            System.out.println("验证失败");
    }


    //redis事务，先组队，再执行，组队时出错都不会执行，执行时出错只有出错的不执行 multi->multi.操作->multi.exec

    //watch关键词来实现乐观锁

    //持久化方式：RDB和AOF，一个记数据一个记操作，都需要在配置文件中开启

    //主从复制，动从不动主，用slaveof ip host来设置从
    //从挂了，重启变成主；主挂了，重启还是主
    //添加哨兵需要添加配置文件sentinel.conf，然后用redis -sentinel 配置文件 来启动

    //开启集群也需要在配置文件中修改，用指定命令将几个端口合并成一个集群，连接时用redis-cli -c -p 端口号


    //几个问题
    //1、缓存穿透：一直访问不存在的资源，在缓存中查找不到，会到数据库中查找，但数据库中也不存在，同时无法往缓存中添加记录，一直访问数据库，导致崩溃
    //2、缓存击穿：某一个key过期了，但是突然大量访问来了，导致数据库压力骤增
    //3、缓存雪崩：批量的key过期
}
