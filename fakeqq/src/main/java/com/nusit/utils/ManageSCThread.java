package com.nusit.utils;

import com.nusit.control.SCThread;

import java.util.HashMap;

public class ManageSCThread {

    private static HashMap<String, SCThread> ThreadPool= new HashMap<>();

    public static HashMap<String, SCThread> getThreadPool() {
        return ThreadPool;
    }

    //将一个用户对应的线程加入到集合中，便于统一管理
    public static void add(String UserId, SCThread sct){
        ThreadPool.put(UserId,sct);
    }

    //按照用户名取出对应的线程
    public static SCThread getByUserId(String UserId){
        return ThreadPool.get(UserId);
    }

    //按照用户名删除线程
    public static void removeByUserId(String UserId){
        ThreadPool.remove(UserId);
    }

}
