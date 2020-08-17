package com.xu.utils;

import com.xu.mybatis.io.Resources;
import com.xu.mybatis.sqlsession.SqlSession;
import com.xu.mybatis.sqlsession.SqlSessionFactory;
import com.xu.mybatis.sqlsession.SqlSessionFactoryBuilder;


import java.io.IOException;
import java.io.InputStream;

public class MybatisUtils {
    
    private static SqlSessionFactory sqlSessionFactory;

    static {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    public static SqlSession getSqlSession(){
        return   sqlSessionFactory.openSession();
    }
}
