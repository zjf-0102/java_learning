package com.nuist;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/*
字节流
 */
public class SocketClient {
    public static void main(String[] args) throws IOException {

        Socket socket = null;
        OutputStream outputStream = null;
        InputStream inputStream = null;

        try {
            //通过socket进行连接
            socket = new Socket(InetAddress.getLocalHost(), 9999);
            //获取输出流
            outputStream = socket.getOutputStream();
            //将数据输出
            outputStream.write("This is a TCP socket Test".getBytes());
            //注意！！！要设置结束标志
            socket.shutdownOutput();
            //接受返回的内容
            inputStream = socket.getInputStream();
            byte[] bytes = new byte[1024];
            int readLen = 0;
            while((readLen = inputStream.read(bytes))!=-1){
                System.out.println(new String(bytes,0,readLen));
            }

            //重新连接  （行得通，但是不合理，重开socket不是之前那个了）
            socket = new Socket(InetAddress.getLocalHost(), 9999);
            outputStream = socket.getOutputStream();
            //最后返回确认
            outputStream.write("I Know too! Let's begin!".getBytes());


        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            inputStream.close();
            outputStream.close();
            socket.close();
        }

    }
}
