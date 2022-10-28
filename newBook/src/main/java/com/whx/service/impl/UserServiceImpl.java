package com.whx.service.impl;

import com.whx.dao.BaseDao;
import com.whx.dao.UserDao;
import com.whx.dao.impl.UserDaoImpl;
import com.whx.pojo.User;
import com.whx.service.UserService;

/**
 * @author WhitehatXiao
 * @date 2022/10/3
 * @descriptions
 */
public class UserServiceImpl implements UserService {


    private UserDao userDao = new UserDaoImpl();

    @Override
    public User checkUser(String username, String password) {
        return  userDao.queryByUsernameAndPassword(username, password);
    }

    @Override
    public int registUser(User user) {
        return  userDao.saveUser(user);
    }

    @Override
    public User ExistUsername(String username) {
        return userDao.queryByUsername(username);
    }


}
