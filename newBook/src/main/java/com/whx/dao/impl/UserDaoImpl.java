package com.whx.dao.impl;

import com.whx.dao.UserDao;
import com.whx.pojo.User;

/**
 * @author WhitehatXiao
 * @date 2022/10/3
 * @descriptions
 */
public class UserDaoImpl extends BaseDaoImpl implements UserDao {

    @Override
    public int saveUser(User user) {
        String sql = "insert into t_user values(?,?,?,?,?)";
        return update(sql, user.getId() , user.getUsername() , user.getPassword() , user.getEmail() , user.getIsAdmin());
    }

    @Override
    public User queryByUsernameAndPassword(String username, String password) {
        String sql = "select * from t_user where username = ? and password = ?";
        return queryForOne(User.class, sql, username, password);
    }

    @Override
    public User queryByUsername(String username) {
        String sql = "select * from t_user where username = ?";
        return queryForOne(User.class, sql, username);
    }
}
