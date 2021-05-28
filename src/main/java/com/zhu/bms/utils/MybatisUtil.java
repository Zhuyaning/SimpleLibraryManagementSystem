package com.zhu.bms.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatisUtil {

    private MybatisUtil() {
    }

    private static SqlSession sqlSession = null;

    static {
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory sqlSessionFactory = builder.build(inputStream);
            sqlSession = sqlSessionFactory.openSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSession getSqlSession() {
        return sqlSession;
    }
}
