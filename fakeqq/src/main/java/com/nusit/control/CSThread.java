package com.nusit.control;

import com.nusit.model.Message;
import com.nusit.model.MessageType;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.Socket;

public class CSThread extends Thread {

    private Socket socket = null;

    public CSThread(Socket socket){
        this.socket = socket;
    }

    public Socket getSocket() {
        return socket;
    }

    @Override
    public void run() {
        while (true) {

            try {

                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                Message message = (Message) ois.readObject();
                if (message.getMsgType().equals(MessageType.MESSAGE_RETURN_ONLINE)){
                    String[] s = message.getContent().split(" ");
                    System.out.println();
                    System.out.println("=========在线用户=========");
                    for (String string:s) {
                        System.out.println(string);
                    }
                    System.out.println("=========在线用户=========");
                } else if (message.getMsgType().equals(MessageType.MESSAGE_COM_MSG)){
                    System.out.println("\n"+message.getSender()+"对"+message.getReceiver()+"说："+message.getContent());
                } else if (message.getMsgType().equals(MessageType.MESSAGE_ALL_MSG)){
                    System.out.println("\n"+message.getSender()+"对大家说："+message.getContent());
                } else if (message.getMsgType().equals(MessageType.MESSAGE_FILE_MSG)){
                    OutputStream os = new FileOutputStream(message.getDest());
                    os.write(message.getFile());
                    os.close();
                }

            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
