package com.nusit.model;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable {

    private String UserId;//用户标识
    private String Password;//用户密码

    public User(String userId, String password) {
        UserId = userId;
        Password = password;
    }

    public User() {

    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(UserId, user.UserId) && Objects.equals(Password, user.Password);
    }

}
