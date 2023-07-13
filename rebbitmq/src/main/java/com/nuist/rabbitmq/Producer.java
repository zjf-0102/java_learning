package com.nuist.rabbitmq;

import com.rabbitmq.client.*;

public class Producer {

    public static void main(String[] args) throws Exception {

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

        //开启发布确认，消息存到磁盘以后告诉发布者一声
        channel.confirmSelect();
        //异步：通过监听器来接收
        channel.addConfirmListener(
                (tags, b) -> System.out.println("确认了的"),
                (tags, b) -> System.out.println("没确认的")
        );


        //通过channel和消息队列连接，参数：队列名称，队列是否持久化，是否消息共享，是否自动删除，其他参数
        channel.queueDeclare("队列名称", true, false, false, null);
        //通过channel发送消息
        channel.basicPublish("交换机", "路由的key值，本次是队列名称", MessageProperties.PERSISTENT_TEXT_PLAIN, "要发送的消息体".getBytes());

        //同步：分单个确认和批量确认
        channel.waitForConfirms();

    }

}
