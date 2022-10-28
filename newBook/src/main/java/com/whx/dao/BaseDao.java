package com.whx.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author WhitehatXiao
 * @date 2022/10/3
 * @descriptions
 */
public interface BaseDao {


    // QueryRunner qr = new QueryRunner();

    /***
     * 该方法用来执行 事务安全的 update , insert , delete 操作
     * @param sql
     * @param params
     * @return
     */
    public int tSafeUpdate(String sql,Object ...params) throws SQLException;




    /***
     * 该方法用来执行 update , insert , delete 操作
     * @param sql
     * @param params
     * @return
     */
    public int update(String sql,Object ...params);

    /***
     * 从数据库放回单行 JavaBean对象
     * @param clazz
     * @param sql
     * @param params
     * @param <T>
     * @return
     */
    public <T> T queryForOne(Class<T> clazz ,String sql,Object ...params);

    /***
     * 查询从数据库并放回多行 JavaBean对象
     * @param clazz
     * @param sql
     * @param params
     * @param <T>
     * @return
     */
    public <T> List<T> queryForList(Class<T> clazz , String sql , Object ...params);

    /***
     * 执行放回一行一列sql语句
     * @param sql
     * @param params
     * @return
     */
    public Object queryForSingleValue(String sql , Object ...params );

}
