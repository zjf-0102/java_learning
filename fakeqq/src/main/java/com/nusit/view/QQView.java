package com.nusit.view;

import com.nusit.control.QQClient;

import java.util.Scanner;

public class QQView {

    private boolean loop = true;
    private String Key;
    private QQClient ClientService = new QQClient();

    public void mainMenu() {

        while (loop) {
            System.out.println("==========QQ============");
            System.out.println("\t\t 1. 登录");
            System.out.println("\t\t 9. 退出");
            System.out.print("请选择：");
            Key = new Scanner(System.in).next();
            switch (Key) {
                case "1":
                    System.out.print("请输入用户名：");
                    String UserId = new Scanner(System.in).next();
                    System.out.print("请输入密  码：");
                    String Password = new Scanner(System.in).next();
                    //将信息发送到服务器进行验证

                    //如果验证通过就表示登陆成功
                    if (ClientService.checkUser(UserId, Password)) {
                        while (loop) {
                            System.out.println("===========欢迎(" + UserId + ")===========");
                            System.out.println("\t\t 1. 显示在线用户");
                            System.out.println("\t\t 2. 群发");
                            System.out.println("\t\t 3. 私聊");
                            System.out.println("\t\t 4. 发送文件");
                            System.out.println("\t\t 9. 退出");
                            System.out.print("请选择：");
                            Key = new Scanner(System.in).next();
                            switch (Key) {
                                case "1":
                                    ClientService.requestOlines();
                                    break;
                                case "2":
                                    System.out.print("输入要群发的内容：");
                                    String content1 = new Scanner(System.in).next();
                                    ClientService.chatToAll(content1);
                                    break;
                                case "3":
                                    System.out.print("输入要发送的用户名(离线也行了)：");
                                    String target = new Scanner(System.in).next();
                                    System.out.print("输入要发送的内容：");
                                    String content = new Scanner(System.in).next();
                                    ClientService.chatToOne(target, content);
                                    break;
                                case "4":
                                    //我就不写了，怕电脑多出来一堆文件
                                    //原理和上面一样，用ByteArrayInputStream和ByteArrayOutputStream
                                    //写吧写吧，不用就行
                                    String src = "文件原始位置";
                                    String dest = "文件目标位置";
                                    String receiver = "接收者";
                                    ClientService.sendFileToOne(src, dest, receiver);
                                    break;
                                case "9":
                                    ClientService.logout();
                                    loop = false;
                                    break;

                            }
                        }
                    } else {
                        System.out.println("登陆失败");
                    }
                    break;
                case "9":
                    loop = false;
                    break;

            }
        }

    }

    public static void main(String[] args) {
        new QQView().mainMenu();
    }
}
