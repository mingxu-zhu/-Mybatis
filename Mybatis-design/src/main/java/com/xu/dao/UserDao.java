package com.xu.dao;

import com.xu.mybatis.annotations.Select;
import com.xu.pojo.User;

import java.util.List;

public interface UserDao {
    //使用xml
    //List<User> getUserList();
    //使用注解
    @Select("select * from mybatis.user")
    List<User> getUserList();
}
