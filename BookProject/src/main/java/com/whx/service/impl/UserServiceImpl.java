package com.whx.service.impl;

import com.whx.dao.UserDao;
import com.whx.dao.impl.UserDaoImpl;
import com.whx.pojo.User;
import com.whx.service.UserService;

/**
 * @author WhitehatXiao
 * @date 2022/9/21
 * @descriptions
 */
public class UserServiceImpl implements UserService {

    private UserDao ud = new UserDaoImpl();

    @Override
    public void regisUser(User user) {
        ud.saveUser(user);
    }

    @Override
    public User login(User user) {
        return ud.queryUserByUsernameAndPassword(user.getUsername(), user.getPassword()) ;
    }

    @Override
    public boolean existsUsername(String username) {
        if(ud.queryUserByUsername(username) == null){
            return false;
        }
        return true;
    }
}
