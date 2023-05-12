package com.nusit.utils;

import com.nusit.control.CSThread;

import java.util.HashMap;

public class ManageCSThread {

    private static HashMap<String, CSThread> ThreadPool= new HashMap<>();

    //将一个用户对应的线程加入到集合中，便于统一管理
    public static void add(String UserId, CSThread cst){
        ThreadPool.put(UserId,cst);
    }

    //按照用户名取出对应的线程
    public static CSThread getByUserId(String UserId){
        return ThreadPool.get(UserId);
    }


}
