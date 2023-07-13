package com.nuist.rabbitmq;

import com.rabbitmq.client.*;

import java.util.Arrays;

public class Consumer {

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

        //设置不公平分发
        channel.basicQos(1);

        //通过channel发送消息，参数：队列名称，消费成功后是否自动应答，消费后的回调，中断的回调
        channel.basicConsume("队列名称", true, (s, delivery) -> System.out.println(Arrays.toString(delivery.getBody())), (a) -> System.out.println("消费中断"));
        //情况分析：取消自动应答，在回调函数中手动应答
        channel.basicConsume("队列名称", false, (s, delivery) -> {
            System.out.println(Arrays.toString(delivery.getBody()));
            //参数：应答的那个消息的标志，是否批量应答
            channel.basicAck(delivery.getEnvelope().getDeliveryTag(),false);
        }, (a) -> System.out.println("消费中断"));

    }

}
