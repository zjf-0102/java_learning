package com.nuist;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {
    public static void main(String[] args) {

        try {
            //可以得到本机的名称和IP地址
            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println(localHost);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }

    }
}
