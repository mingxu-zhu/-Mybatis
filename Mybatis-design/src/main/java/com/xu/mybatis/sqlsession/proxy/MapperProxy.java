package com.xu.mybatis.sqlsession.proxy;

import com.xu.mybatis.cfg.Mapper;
import com.xu.mybatis.utils.Executor;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.Map;

public class MapperProxy implements InvocationHandler {
    private Map<String, Mapper> mappers;
    private Connection coon;

    public MapperProxy(Map<String, Mapper> mappers, Connection coon) {
        this.mappers = mappers;
        this.coon = coon;
    }

    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        String methodName = method.getName();
        String className = method.getDeclaringClass().getName();
        String key =className+"."+methodName;
        Mapper mapper = mappers.get(key);
        if (mapper==null){
            throw new IllegalAccessException("传入参数异常");
        }
        return new Executor().selectList(mapper,coon);
    }
}
