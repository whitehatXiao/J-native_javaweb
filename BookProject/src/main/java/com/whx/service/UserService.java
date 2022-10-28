package com.whx.service;

import com.whx.pojo.User;

/**
 * @author WhitehatXiao
 * @date 2022/9/21
 * @descriptions 使用 UserService 层功能且制定规范
 */
public interface UserService {


    /**
     *  注册用户
     * @param user
     * @return 成功放回 ， 不成功放回 -1
     */
    public void regisUser(User user);

    /**
     * 检查用户名是否可用
     * @param user
     * @return 放回user对象登陆成功，否则返回null
     */
    public User login(User user);


    /**
     * 验证用户是否已近存在
     * @param username
     * @return 存在则为true ， 反正依然
     */
    public boolean existsUsername(String username);

}
