package com.zhu.bms.service.impl;


import com.zhu.bms.domain.User;
import com.zhu.bms.mapper.UserMapper;
import com.zhu.bms.mapper.impl.UserMapperImpl;
import com.zhu.bms.service.UserService;

import java.util.List;

/***
 *   Created by IntelliJ IDEA.
 *   User: ZhuYaning
 *   Date: 2021/4/24
 *   Time: 15:32
 */

public class UserServiceImpl implements UserService {

    UserMapper userMapper = new UserMapperImpl();

    @Override
    public String register(User user) {
        userMapper.save(user);
        return "注册成功";
    }

    @Override
    public User login(User user) {
        User login = userMapper.login(user);
        return login;
    }

    @Override
    public Integer deleteUser(Long id) {
        userMapper.delete(id);
        return 1;
    }

    @Override
    public List<User> queryAllUser() {
        return userMapper.queryAll();
    }

    @Override
    public User query(Long id) {
        return userMapper.query(id);
    }

    @Override
    public void updateUser(User user) {
        userMapper.update(user);
    }
}
