package com.nuist;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/*
字符流
 */
public class SocketServerNew {
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(9999);
        Socket socket = serverSocket.accept();

        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();

        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(outputStream));

        //读
        String s = null;
        s = br.readLine();
        System.out.println(s);
        /*
            //这两行表示一直读，读到字符串null停下来，while循环可以一次读取多句话
            while (!(s = br.readLine()).equals("null"))
                System.out.println(s);
         */

        //回
        bw.write("你好服务器，我收到了，你呢？");
        bw.newLine();
        bw.flush();

        //再读
        s = br.readLine();
        System.out.println(s);

        bw.close();
        br.close();
        socket.close();
        serverSocket.close();

    }
}
