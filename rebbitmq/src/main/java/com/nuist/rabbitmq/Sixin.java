package com.nuist.rabbitmq;

import com.rabbitmq.client.*;

import java.util.Arrays;
import java.util.HashMap;

public class Sixin {

    /**
     * 死信队列
     *
     * 延迟队列其实也是用到了死信队列，让消息超过时间转发到死信队列，再由消费者处理，从而实现延时的效果
     * 不过，该方法需要消息在队列中排队，后来的消息会因此没办法在超时后及时到死信队列中
     * 解决方法：基于插件的延迟队列
     * 原理不同：基于死信队列的在一般队列中延时，基于插件的在交换机中延时（交换机类型为延迟类型）
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


    //接收消息
    public static void consumer() throws Exception{
        Channel channel = getChannel();

        //普通队列，这时候因为要和死信队列相关联，所以需要设置参数
        HashMap<String, Object> parameters = new HashMap<>();
        parameters.put("x-dead-letter-exchange", "死信队列对应的交换的名称");
        parameters.put("x-dead-letter-routing-key", "放routing-key");
        parameters.put("x-message-ttl", 100000);
        channel.queueDeclare("队列名称", true, false, false, parameters);

        //死信队列就是一个普通的队列

        channel.basicConsume("队列名称", true, (s, delivery) -> System.out.println(Arrays.toString(delivery.getBody())), (a) -> System.out.println("消费中断"));

    }

    //发送消息
    public static void producer() throws Exception{
        Channel channel = getChannel();
        //创建交换机
        channel.exchangeDeclare("交换机名称", BuiltinExchangeType.FANOUT);
        //这时候就不要发给队列了，发给交换机
        //需要设置过期时间
        AMQP.BasicProperties build = new AMQP.BasicProperties().builder().expiration("10000").build();
        channel.basicPublish("交换机名称","类似于密码", build,"消息内容".getBytes());
    }

}
