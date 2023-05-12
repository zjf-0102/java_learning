package com.nuist.singleton;

/**
 * 单例模式--懒汉式
 */
public class BoyFriend {
    private String name;
    private static BoyFriend boyFriend;


    private BoyFriend(String name) {
        this.name = name;
    }

    public static BoyFriend getInstance() {
        if (boyFriend == null)
            return new BoyFriend("anand");
        return boyFriend;
    }

}
