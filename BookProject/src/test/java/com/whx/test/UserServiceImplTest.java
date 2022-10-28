package com.whx.test;

import com.whx.dao.impl.BaseDao;
import com.whx.pojo.User;
import com.whx.service.UserService;
import com.whx.service.impl.UserServiceImpl;
import org.junit.Test;

/**
 * @author WhitehatXiao
 * @date 2022/9/21
 * @descriptions
 */
public class UserServiceImplTest extends BaseDao {

    UserService userService = new UserServiceImpl();

    @Test
    public void registUser() {
        userService.regisUser(new User("hello11", "666666", "bbj168@qq.com"));
        userService.regisUser(new User("world11", "666666", "abc168@qq.com"));
    }

    @Test
    public void login() {
        System.out.println(userService.login(new User("linlin", "whitehat@00", null)));
    }

    @Test
    public void existsUsername() {
        if (userService.existsUsername("linlin")) {
            System.out.println("用户名已存在！");
        } else {
            System.out.println("用户名可用！");
        }
    }
}