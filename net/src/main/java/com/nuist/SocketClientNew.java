package com.nuist;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/*
字符流
 */
public class SocketClientNew {
    public static void main(String[] args) throws IOException {

        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);

        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();

        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(outputStream));

        //写
        bw.write("你好服务器，我是客户端，你听到吗？");
        //这里必须要newLine()，因为这是给上一句话加上一个换行符，readLine()在读到换行符时才会终止，服务器端才不会一直读
        bw.newLine();
        /*
            //这两句话的意思是，最后写一个null字符串作为结束标识
            bw.write("null");
            bw.newLine();
         */
        bw.flush();

        //接
        String s = br.readLine();
        System.out.println(s);

        //回
        bw.write("我也听到了，我们开始吧！");
        bw.newLine();
        bw.flush();

        bw.close();
        br.close();
        socket.close();

    }
}
