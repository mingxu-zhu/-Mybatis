package com.xu.mybatis.sqlsession;

import com.xu.mybatis.cfg.Configuration;
import com.xu.mybatis.sqlsession.defaults.DefaultSqlSessionFactory;
import com.xu.mybatis.utils.XMLConfigBuilder;


import java.io.InputStream;

public class SqlSessionFactoryBuilder {
    public SqlSessionFactory build(InputStream in){
        Configuration cfg = XMLConfigBuilder.loadConfiguration(in);
        return new DefaultSqlSessionFactory(cfg);
    }
}
