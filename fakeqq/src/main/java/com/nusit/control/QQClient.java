package com.nusit.control;

import com.nusit.model.Message;
import com.nusit.model.MessageType;
import com.nusit.model.User;
import com.nusit.utils.ManageCSThread;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class QQClient {

    private User user = new User();
    private Socket socket = null;

    public boolean checkUser(String UserId, String Password) {
        user.setUserId(UserId);
        user.setPassword(Password);

        try {
            socket = new Socket(InetAddress.getByName("127.0.0.1"), 9999);
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(user);

            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            Message message = (Message) ois.readObject();
            if (message.getMsgType().equals(MessageType.MESSAGE_LOGIN_SUCCEED)) {
                CSThread cst = new CSThread(socket);
                cst.start();
                ManageCSThread.add(UserId,cst);
                return true;
            } else{
                socket.close();
                return false;
            }

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void requestOlines() {

        Message message = new Message();
        message.setMsgType(MessageType.MESSAGE_GET_ONLINE);
        message.setSender(user.getUserId());
        try {
            ObjectOutputStream oos = new ObjectOutputStream(ManageCSThread.getByUserId(user.getUserId()).getSocket().getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void logout() {
        Message message = new Message();
        message.setMsgType(MessageType.MESSAGE_CLIENT_EXIT);
        message.setSender(user.getUserId());
        try {
            ObjectOutputStream oos = new ObjectOutputStream(ManageCSThread.getByUserId(user.getUserId()).getSocket().getOutputStream());
            oos.writeObject(message);
            System.exit(0);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void chatToOne(String target, String content) {
        Message message = new Message();
        message.setMsgType(MessageType.MESSAGE_COM_MSG);
        message.setSender(user.getUserId());
        message.setReceiver(target);
        message.setContent(content);
        try {
            ObjectOutputStream oos = new ObjectOutputStream(ManageCSThread.getByUserId(user.getUserId()).getSocket().getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void chatToAll(String content) {
        Message message = new Message();
        message.setMsgType(MessageType.MESSAGE_ALL_MSG);
        message.setSender(user.getUserId());
        message.setContent(content);
        try {
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void sendFileToOne(String src, String dest, String receiver) {

        Message message = new Message();
        message.setMsgType(MessageType.MESSAGE_FILE_MSG);
        message.setSender(user.getUserId());
        message.setReceiver(receiver);
        message.setDest(dest);
        InputStream is = null;
        ByteArrayOutputStream bos = null;
        byte[] bytes = new byte[1024];
        try {
            is = new FileInputStream(src);
            bos = new ByteArrayOutputStream();
            while ((is.read(bytes))!=-1){
                bos.write(bytes);
            }
            message.setFile(bos.toByteArray());
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                bos.close();
                is.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
