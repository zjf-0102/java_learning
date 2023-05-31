package com.xxx.dao;

import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao{
    @Override
    public void testDao() {
        System.out.println("testDao....");
    }
}
