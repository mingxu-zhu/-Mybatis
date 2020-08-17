package com.xu.dao;

import com.xu.mybatis.io.Resources;
import com.xu.mybatis.sqlsession.SqlSession;
import com.xu.mybatis.sqlsession.SqlSessionFactory;
import com.xu.mybatis.sqlsession.SqlSessionFactoryBuilder;
import com.xu.pojo.User;

import java.io.InputStream;
import java.util.List;

public class Tese {
        /**
         * 入门案例
         * @param args
         */
        public static void main(String[] args)throws Exception {
            //1.读取配置文件
            InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
            //2.创建SqlSessionFactory工厂
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory factory = builder.build(in);
            //3.使用工厂生产SqlSession对象
            SqlSession session = factory.openSession();
            //4.使用SqlSession创建Dao接口的代理对象
            UserDao userDao = session.getMapper(UserDao.class);
            //5.使用代理对象执行方法
            List<User> users = userDao.getUserList();
            for(User user : users){
                System.out.println(user);
            }
            //6.释放资源
            session.close();
            in.close();
        }
    }

