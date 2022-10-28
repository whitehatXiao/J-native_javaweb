package com.whx.test;

import com.whx.dao.UserDao;
import com.whx.dao.impl.UserDaoImpl;
import com.whx.pojo.User;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author WhitehatXiao
 * @date 2022/9/21
 * @descriptions
 */
public class UserDaoImplTest{

    UserDao UD = new UserDaoImpl();

    @Test
    public void queryUserByUsername() {
        if(UD.queryUserByUsername("admin") == null){
            System.out.println("用户名可用！");
        }else {
            System.out.println("用户名不可用 ! ");
        }
    }

    @Test
    public void queryUserByUsernameAndPassword() {
        if( UD.queryUserByUsernameAndPassword("linlin","whitehat@00") == null){
            System.out.println("用户登陆失败！");
        }else {
            System.out.println("登陆成功");
        }
    }

    @Test
    public void saveUser() {
        if(UD.saveUser(new User(1,"admin","admin","google@qq.com"))== -1 ){
            System.out.println("注册成功");
        }else
            System.out.println("注册失败");
    }
}