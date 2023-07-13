package com.nuist.rabbitmq;

import com.rabbitmq.client.*;

import java.util.Arrays;

public class Exchange {

    /**
     * 发布订阅模式fanout：同时发给多个队列
     * 路由模式direct：发给指定的一个队列
     * 主题模式topic:发给指定的多个队列（指定routingKey的时候，用*代替一个单词，#代替0或多个单词）
     * 总结：主要就是两步，一是改交换机类型。二是改routingKey的值
     */

    public static Channel getChannel() throws Exception{
        //创建连接工厂
        ConnectionFactory connectionFactory = new ConnectionFactory();
        //设置连接信息
        connectionFactory.setHost("ip地址");
        connectionFactory.setUsername("用户名");
        connectionFactory.setPassword("密码");
        //从工厂获取连接
        Connection connection = connectionFactory.newConnection();
        //从连接获取通道
        Channel channel = connection.createChannel();
        return channel;
    }

    //发送消息
    public static void producer() throws Exception{
        Channel channel = getChannel();
        //创建交换机
        channel.exchangeDeclare("交换机名称", BuiltinExchangeType.FANOUT);
        //这时候就不要发给队列了，发给交换机
        channel.basicPublish("交换机名称","类似于密码", MessageProperties.PERSISTENT_TEXT_PLAIN,"消息内容".getBytes());
    }

    //接收消息
    public static void consumer() throws Exception{
        Channel channel = getChannel();
        //创建交换机
        channel.exchangeDeclare("交换机名称", BuiltinExchangeType.FANOUT);
        //创建临时队列
        String queue = channel.queueDeclare().getQueue();
        //进行绑定
        channel.queueBind("队列名称","交换机名称","类似于密码");

        channel.basicConsume("队列名称", true, (s, delivery) -> System.out.println(Arrays.toString(delivery.getBody())), (a) -> System.out.println("消费中断"));


    }

}
