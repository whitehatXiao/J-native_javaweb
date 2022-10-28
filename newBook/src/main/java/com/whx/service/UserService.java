package com.whx.service;

import com.whx.pojo.User;

/**
 * @author WhitehatXiao
 * @date 2022/10/3
 * @descriptions
 */
public interface UserService {

    public User checkUser(String username , String password);

    public int registUser(User user );

    public User ExistUsername( String username);


}
