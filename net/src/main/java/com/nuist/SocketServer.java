package com.nuist;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
字节流
 */
public class SocketServer {
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream inputStream = null;
        OutputStream outputStream = null;

        try {
            //服务器端监听 9999 端口
            serverSocket = new ServerSocket(9999);
            //等待连接，这时没有连接会阻塞，程序会一直等待
            socket = serverSocket.accept();
            //连接成功后可以获取相关的输入流
            inputStream = socket.getInputStream();
            //读取其中的内容
            byte[] bytes = new byte[1024];
            int readLen = 0;
            while((readLen = inputStream.read(bytes))!=-1){
                System.out.println(new String(bytes,0,readLen));
            }

            //返回内容
            outputStream = socket.getOutputStream();
            outputStream.write("I Know! You Know?".getBytes());
            //注意！！！要设置结束标志
            socket.shutdownOutput();

            //输出流关闭了，重新等待连接
            socket = serverSocket.accept();
            inputStream = socket.getInputStream();
            //接受客户端的最后确认
            while((readLen = inputStream.read(bytes))!=-1){
                System.out.println(new String(bytes,0,readLen));
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            outputStream.close();
            inputStream.close();
            socket.close();
            serverSocket.close();
        }

    }
}
