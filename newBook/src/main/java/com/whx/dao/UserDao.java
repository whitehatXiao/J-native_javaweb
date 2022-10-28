package com.whx.dao;

import com.whx.pojo.User;

/**
 * @author WhitehatXiao
 * @date 2022/10/3
 * @descriptions
 */
public interface UserDao  {

    public int saveUser(User user);

    public User queryByUsernameAndPassword(String username , String password);

    public User queryByUsername(String username);

}
