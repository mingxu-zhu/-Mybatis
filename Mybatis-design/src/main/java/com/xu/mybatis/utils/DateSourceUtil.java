package com.xu.mybatis.utils;

import com.xu.mybatis.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DateSourceUtil {
    public static Connection getConnection(Configuration cfg){
try{
    Class.forName(cfg.getDriver());
    return DriverManager.getConnection(cfg.getUrl(),cfg.getUsername(),cfg.getPassword());
}catch (Exception e){
    throw new RuntimeException(e);
}

    }
}
