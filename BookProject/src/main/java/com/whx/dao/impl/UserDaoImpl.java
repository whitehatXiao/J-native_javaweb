package com.whx.dao.impl;

import com.whx.dao.UserDao;
import com.whx.pojo.User;

/**
 * @author WhitehatXiao
 * @date 2022/9/21
 * @descriptions
 */
public class UserDaoImpl extends BaseDao implements UserDao {

    @Override
    public User queryUserByUsername(String username) {
        String sql = "select * from t_user where username = ?";
        return queryForOne(User.class, sql, username);
    }

    @Override
    public User queryUserByUsernameAndPassword(String username, String password) {
        String sql = "select * from t_user where username = ? and password = ?" ;
        return queryForOne(User.class, sql, username,password);
    }

    @Override
    public int saveUser(User user) {
        String sql = "insert into t_user(username,password,email) values(?,?,?)";
        return  update(sql, user.getUsername(), user.getPassword(), user.getEmail());
    }
}
