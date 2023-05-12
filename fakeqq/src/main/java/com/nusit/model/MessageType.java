package com.nusit.model;

public interface MessageType {

    String MESSAGE_LOGIN_SUCCEED = "1";
    String MESSAGE_LOGIN_FAIL = "2";
    String MESSAGE_COM_MSG = "3";//普通消息
    String MESSAGE_ALL_MSG = "7";//群发消息
    String MESSAGE_GET_ONLINE = "4";//获取在线用户
    String MESSAGE_RETURN_ONLINE = "5";//返回在线用户
    String MESSAGE_CLIENT_EXIT = "6";//客户端退出
    String MESSAGE_FILE_MSG = "8";//发送文件

}
