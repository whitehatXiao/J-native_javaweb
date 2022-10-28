package com.whx.dao.impl;

import com.mysql.jdbc.MiniAdmin;
import com.whx.dao.UserDao;
import com.whx.pojo.User;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author WhitehatXiao
 * @date 2022/10/3
 * @descriptions
 */
public class UserDaoImplTest {

    UserDao userDao = new UserDaoImpl();

    @Test
    public void saveUser() {
        System.out.println(userDao.saveUser(new User(null, "whitehat", "whitehat", "whitehat@qq.com", null)));
    }

    @Test
    public void queryByUsernameAndPassword() {
        System.out.println(userDao.queryByUsernameAndPassword("admin", "admin"));
    }

    @Test
    public void queryByUsername() {
        System.out.println(userDao.queryByUsername("whitehat"));
    }
}