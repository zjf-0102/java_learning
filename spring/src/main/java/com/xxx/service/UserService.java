package com.xxx.service;

import com.xxx.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("userService")
public class UserService {

    @Autowired
    private UserDao userDao;

    public void test() {
        System.out.println("test....");
        userDao.testDao();
    }

}
