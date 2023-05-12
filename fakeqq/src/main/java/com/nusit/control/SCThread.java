package com.nusit.control;

import com.nusit.model.Message;
import com.nusit.model.MessageType;
import com.nusit.utils.ManageSCThread;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class SCThread extends Thread {

    private Socket socket = null;
    private String UserId;
    private static ConcurrentHashMap<String, ArrayList<Message>> OfflineMsg = new ConcurrentHashMap<>();//存储离线的消息，方便起见，只考虑私发的情况，其他同理

    public SCThread(Socket socket, String UserId) {
        this.socket = socket;
        this.UserId = UserId;
    }

    public Socket getSocket() {
        return socket;
    }

    @Override
    public void run() {

        //启动线程时先找一下OfflineMsg里有没有记录，只有登陆时检查一次
        if (OfflineMsg.containsKey(UserId)) {//如果有，拿出来接受
            ArrayList<Message> messages = OfflineMsg.get(UserId);
            try {
                for (Message message:messages) {
                    ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                    oos.writeObject(message);
                }
                //写完之后把记录删了
                OfflineMsg.remove(UserId);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        while (true) {

            try {

                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                Message message = (Message) ois.readObject();
                if (message.getMsgType().equals(MessageType.MESSAGE_GET_ONLINE)) {
                    String online = getOnlines();
                    ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                    Message message1 = new Message();
                    message1.setMsgType(MessageType.MESSAGE_RETURN_ONLINE);
                    message1.setContent(online);
                    message1.setReceiver(UserId);
                    oos.writeObject(message1);
                } else if (message.getMsgType().equals(MessageType.MESSAGE_CLIENT_EXIT)) {
                    ManageSCThread.getByUserId(UserId).getSocket().close();
                    ManageSCThread.removeByUserId(UserId);
                    break;//退出while循环，让线程结束
                } else if (message.getMsgType().equals(MessageType.MESSAGE_COM_MSG)) {
                    //判断用户是否在线
                    boolean flag = false;
                    Set<String> users = ManageSCThread.getThreadPool().keySet();
                    for (String user : users) {
                        if (user.equals(message.getReceiver())) {//在线就发送
                            ObjectOutputStream oos = new ObjectOutputStream(ManageSCThread.getByUserId(message.getReceiver()).getSocket().getOutputStream());
                            oos.writeObject(message);
                            flag = true;
                        }
                    }
                    if (!flag) {//不在线就存起来
                        if (OfflineMsg.containsKey(message.getReceiver())) {//已经有了，直接加到list中
                            OfflineMsg.get(message.getReceiver()).add(message);
                        } else {//没有，建个list，再放到map中
                            ArrayList<Message> msgs = new ArrayList<>();
                            msgs.add(message);
                            OfflineMsg.put(message.getReceiver(), msgs);
                        }
                    }

                } else if (message.getMsgType().equals(MessageType.MESSAGE_ALL_MSG)) {
                    Set<String> users = ManageSCThread.getThreadPool().keySet();
                    for (String user : users) {
                        if (user.equals(UserId))
                            continue;
                        ObjectOutputStream oos = new ObjectOutputStream(ManageSCThread.getByUserId(user).getSocket().getOutputStream());
                        Message message1 = new Message();
                        message1.setMsgType(MessageType.MESSAGE_ALL_MSG);
                        message1.setContent(message.getContent());
                        message1.setSender(UserId);
                        oos.writeObject(message1);
                    }
                } else if (message.getMsgType().equals(MessageType.MESSAGE_FILE_MSG)) {
                    ObjectOutputStream oos = new ObjectOutputStream(ManageSCThread.getByUserId(message.getReceiver()).getSocket().getOutputStream());
                    oos.writeObject(message);
                }

            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

        }
    }

    //取出在线用户
    public String getOnlines() {
        StringBuilder sb = new StringBuilder();
        Set<String> keys = ManageSCThread.getThreadPool().keySet();
        for (String key : keys) {
            sb.append(key).append(" ");
        }
        return sb.toString();
    }

}
