package com.nuist.singleton;

/**
 * 单例模式--饿汉式
 */
public class GirlFriend {
    private String name;
    private static GirlFriend girlFriend = new GirlFriend("yoona");


    private GirlFriend(String name) {
        this.name = name;
    }

    public static GirlFriend getInstance() {
        return girlFriend;
    }

}
