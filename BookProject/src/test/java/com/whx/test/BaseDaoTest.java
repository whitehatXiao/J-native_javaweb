package com.whx.test;

import com.whx.dao.impl.BaseDao;

import com.whx.pojo.User;
import com.whx.utils.DdbcUtils;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author WhitehatXiao
 * @date 2022/10/3
 * @descriptions
 */
public class BaseDaoTest {

    // BaseDao baseDao = new BaseDao();
    //
    // @Test
    // public void update() {
    //     String sql = "insert into t_user VALUES(null,?,?,?)";
    //     System.out.println(baseDao.update(sql, "dandan","admin","admin123@qq,com"));
    // }
    //
    // @Test
    // public void tSafeupdate() {
    //     String sql = "insert into t_user VALUES(null,?,?,?)";
    //     try {
    //         System.out.println(baseDao.tSafeupdate(sql, "dandantwo","admin","admin@qq.com"));
    //         DdbcUtils.commitAndClose();
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //         DdbcUtils.rollbackAndClose();
    //     }
    // }
    //
    // @Test
    // public void queryForOne() {
    //     String sql = "select * from t_user where id = ?";
    //     System.out.println(baseDao.queryForOne(User.class, sql, 1));
    // }
    //
    // @Test
    // public void queryForList() {
    //     String sql = "select * from t_user";
    //     System.out.println(baseDao.queryForList(User.class, sql));
    // }
    //
    // @Test
    // public void queryForSingleValue() {
    //     String sql = "select count(*) from t_user";
    //     System.out.println(baseDao.queryForSingleValue(sql));
    // }
}