package com.zhu.bms.service;

import com.zhu.bms.domain.User;

import java.util.List;

/***
 *   Created by IntelliJ IDEA.
 *   User: ZhuYaning
 *   Date: 2021/4/24
 *   Time: 15:26
 */

public interface UserService {
    /***
     * 用户注册
     * @param user
     * @return
     */
    String register(User user);

    /***
     * 用户登录
     * @param user
     * @return
     */
    User login (User user);

    /***
     * 删除用户
     * @param id
     * @return
     */
    Integer deleteUser(Long id);

    /***
     * 查询所有用户
     * @return
     */
    List<User> queryAllUser();

    /***
     * 根据用户id查询用户
     * @param id
     * @return
     */
    User query(Long id);

    /***
     * 修改user
     * @param user
     */
    void updateUser(User user);
}
