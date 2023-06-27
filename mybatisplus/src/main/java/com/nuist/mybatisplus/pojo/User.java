package com.nuist.mybatisplus.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@Data
@TableName("t_user")
public class User {

    @TableId
    private Integer id;

    @TableField("username")
    private String username;

    private String password;

    private Integer age;

    private String sex;

    private String email;

    private Integer cid;
}
