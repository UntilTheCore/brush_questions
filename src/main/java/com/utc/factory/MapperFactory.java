package com.utc.factory;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MapperFactory {
    private static SqlSessionFactory sqlSessionFactory = null;

    static {
        InputStream in = null;
        try {
            //1.读取mybatis主配置文件
            in = Resources.getResourceAsStream("SqlMapConfig.xml");
            //2.创建构建者对象
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            //3.使用构建者创建SqlSessionFactory工厂
            sqlSessionFactory = builder.build(in);
        }catch (Exception e){
            //打印异常信息到控制台
            e.printStackTrace();
            //抛出错误提示程序终止执行
            throw new ExceptionInInitializerError("初始化SqlSessionFactory失败");
        }finally {
            //释放流对象
            if(in != null){
                try{
                    in.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }

    }

    public static SqlSession getSession() {
        if(sqlSessionFactory == null) {
            throw new RuntimeException("SqlSessionFactory is null");
        } else {
            return sqlSessionFactory.openSession(false);
        }
    }

    public static <T> T getMapper(SqlSession sqlSession, Class<T> cls)  {
        if(sqlSession == null) {
            throw new RuntimeException("SqlSession is null");
        } else {
            return sqlSession.getMapper(cls);
        }
    }
}
