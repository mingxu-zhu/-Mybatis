package com.xu.mybatis.sqlsession.defaults;

import com.xu.mybatis.cfg.Configuration;
import com.xu.mybatis.sqlsession.SqlSession;
import com.xu.mybatis.sqlsession.SqlSessionFactory;

public class DefaultSqlSessionFactory implements SqlSessionFactory {
    private Configuration cfg;

    public DefaultSqlSessionFactory(Configuration cfg) {
        this.cfg = cfg;
    }

    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(cfg);
    }
}
