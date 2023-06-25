package com.nuist.mapper;

import com.nuist.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    int insertUser(User user);

    User selectUserById(int id);

    User checkLogin(String username, String password);

    List<User> selectByParam(@Param("username") String username, @Param("password") String password);

    List<User> selectByLike(@Param("username") String username);

    int deleteMore(@Param("ids") String ids);

    User selectDetailUser(@Param("id") int id);

//    分布查询第一步，第二步在ClassMapper里
    User selectByStep(@Param("id") int id);

    User selectUserByCid(@Param("cid") Integer cid);

    List<User> selectByCondition(User user);
}

