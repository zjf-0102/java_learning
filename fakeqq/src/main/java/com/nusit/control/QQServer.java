package com.nusit.control;

import com.nusit.model.Message;
import com.nusit.model.MessageType;
import com.nusit.model.User;
import com.nusit.utils.ManageSCThread;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ConcurrentHashMap;

public class QQServer {

    ServerSocket serverSocket = null;
    private static ConcurrentHashMap<String, User> Users = new ConcurrentHashMap<>();//可以处理并发的HashMap

    static {//模拟数据库
        Users.put("100",new User("100","123456"));
        Users.put("200",new User("200","123456"));
        Users.put("300",new User("300","123456"));
    }

    public QQServer(){

        try {
            serverSocket = new ServerSocket(9999);

            while (true){
                Socket socket = serverSocket.accept();
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                User user = (User) ois.readObject();
                Message message = new Message();

                if (Users.containsValue(user)){
                    message.setMsgType(MessageType.MESSAGE_LOGIN_SUCCEED);
                    oos.writeObject(message);
                    SCThread sct = new SCThread(socket, user.getUserId());
                    sct.start();
                    ManageSCThread.add(user.getUserId(), sct);
                }else{
                    message.setMsgType(MessageType.MESSAGE_LOGIN_FAIL);
                    oos.writeObject(message);
                    socket.close();
                }
            }


        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                serverSocket.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

}
