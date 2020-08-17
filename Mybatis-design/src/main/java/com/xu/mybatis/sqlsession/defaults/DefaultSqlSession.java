package com.xu.mybatis.sqlsession.defaults;

import com.xu.mybatis.cfg.Configuration;
import com.xu.mybatis.cfg.Mapper;
import com.xu.mybatis.sqlsession.SqlSession;
import com.xu.mybatis.sqlsession.proxy.MapperProxy;
import com.xu.mybatis.utils.DateSourceUtil;


import javax.sql.DataSource;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;

public class DefaultSqlSession implements SqlSession {
    private Configuration cfg;
    private Connection connection;

    public DefaultSqlSession(Configuration cfg) {
        this.cfg = cfg;
        connection= DateSourceUtil.getConnection(cfg);
    }

    @Override
    public <T> T getMapper(Class<T> daoInterfaceClass) {
        return (T) Proxy.newProxyInstance(daoInterfaceClass.getClassLoader(),
                new Class[]{daoInterfaceClass},new MapperProxy(cfg.getMappers(),connection));

    }

    @Override
    public void close() {
        if (connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
