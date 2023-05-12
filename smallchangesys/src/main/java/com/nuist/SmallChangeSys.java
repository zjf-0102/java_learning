package com.nuist;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SmallChangeSys {

    private static double balance;//余额
    private static String details = "---------零钱通明细---------";//操作明细

    public static void main(String[] args) {
        boolean flag = true;
        while (flag) {
            System.out.println();
            System.out.println("==========零钱通==========");
            System.out.println("\t1、零钱通明细");
            System.out.println("\t2、收益入账");
            System.out.println("\t3、消费");
            System.out.println("\t4、退出");
            System.out.println();
            System.out.println("请选择1-4操作：");
            int choice = new Scanner(System.in).nextInt();
            switch (choice) {
                case 1:
                    System.out.println(details);
                    break;
                case 2:
                    System.out.println("输入金额");
                    operate("收益入账", new Scanner(System.in).nextDouble(), '+');
                    break;
                case 3:
                    System.out.println("输入描述和金额");
                    operate(new Scanner(System.in).next(), new Scanner(System.in).nextDouble(), '-');
                    break;
                case 4:
                    flag = false;
                    break;
                default:
                    System.out.println("选择错误!!!");
            }
        }

        System.out.println("成功退出零钱通!!!");

    }

    /*
        //    收钱
        public static void saveMoney(double money) {
            balance += money;
            details += "\n收益入账\t\t+" + money + "\t" + new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date()) + "\t" + "余额：" + balance;
            System.out.println("操作成功!!!");
        }

        //    花钱
        public static void consume(String description, double money) {
            balance -= money;
            details += "\n" + description + "\t\t-" + money + "\t" + new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date()) + "\t" + "余额：" + balance;
            System.out.println("操作成功!!!");
        }
    */
    //    封装上面两个方法
    public static void operate(String description, double money, char op) {
        if (op == '+') {
            if (money < 0) {
                System.out.println("金额应大于0");
                return;
            }
            balance += money;
        } else {
            if (money < 0 || money > balance) {
                System.out.println("金额应在0-" + balance + "之间");
                return;
            }
            balance -= money;
        }
        details += "\n" + description + "\t\t" + op + money + "\t" + new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date()) + "\t" + "余额：" + balance;
        System.out.println("操作成功!!!");
    }
}
