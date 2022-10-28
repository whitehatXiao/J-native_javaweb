package com.whx.dao;

import com.whx.pojo.User;

/**
 * @author WhitehatXiao
 * @date 2022/9/21
 * @descriptions  UserDao 编写的接口规范
 */
public interface UserDao {

    /**
     * 根据用户名查询是否存在
     * @param username
     * @return 放回null则不存在
     */
    public User queryUserByUsername(String username);

    /**
     * 根据用户名和密码查询是否存在
     * @param username
     * @param password
     * @return 返回null则代表用户不存在
     */
    public User queryUserByUsernameAndPassword(String username , String password);

    /**
     * 保存用户
     * @param user
     * @return 保存失败返回-1
     */
    public int saveUser(User user);

}
