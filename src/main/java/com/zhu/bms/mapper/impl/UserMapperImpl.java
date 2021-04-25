package com.zhu.bms.mapper.impl;

import com.zhu.bms.domain.User;
import com.zhu.bms.mapper.UserMapper;
import com.zhu.bms.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/***
 *   Created by IntelliJ IDEA.
 *   User: ZhuYaning
 *   Date: 2021/4/24
 *   Time: 15:23
 */

public class UserMapperImpl implements UserMapper {

    SqlSession sqlSession = MybatisUtil.getSqlSession();
    UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

    @Override
    public void save(User user) {
        userMapper.save(user);
        sqlSession.commit();
    }

    @Override
    public void delete(Long id) {
        userMapper.delete(id);
        sqlSession.commit();
    }

    @Override
    public void update(User user) {
        userMapper.update(user);
        sqlSession.commit();
    }

    @Override
    public User query(Long id) {
        return userMapper.query(id);
    }

    @Override
    public List<User> queryAll() {
        return userMapper.queryAll();
    }

    @Override
    public User login(User user) {
        return userMapper.login(user);
    }
}
