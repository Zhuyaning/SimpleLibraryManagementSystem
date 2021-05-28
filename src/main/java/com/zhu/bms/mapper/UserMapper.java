package com.zhu.bms.mapper;

import com.zhu.bms.domain.User;

import java.util.List;

/***
 *   Created by IntelliJ IDEA.
 *   User: ZhuYaning
 *   Date: 2021/4/24
 *   Time: 15:14
 */

public interface UserMapper {
    /***
     * 用户保存
     * @param user
     */
    void save(User user);

    /***
     * 删除用户
     * @param id
     */
    void delete(Long id);

    /***
     * 修改用户
     * @param user
     */
    void update(User user);

    /***
     *  查询用户
     * @param id
     * @return
     */
    User query(Long id);

    /***
     * 查询所有用户
     * @return
     */
    List<User> queryAll();

    /***
     * 登录的实现
     * @param user
     * @return
     */
    User login(User user);
}
