package com.whx.dao.impl;

import com.whx.utils.DdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author WhitehatXiao
 * @date 2022/9/21
 * @descriptions  Dao持久化层，使用DBUtils对数据库经常操作的 ， BaseDao抽象类，可以有默认方法；
 *
 */
public abstract class BaseDao {

    private QueryRunner qr = new QueryRunner();


    /***
     * 该方法用来执行 非事务安全的  update , insert , delete 操作
     * @param sql
     * @param params
     * @return 返回 -1 代表操作失败
     */
    public int update(String sql,Object ...params){

        // 非事务安全的update方法
        Connection connection = DdbcUtils.getConnection();
        try {
            return qr.update(connection, sql, params);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return -1;
    }



    /***
     * 该方法用来执行 update , insert , delete 操作
     * @param sql
     * @param params
     * @return
     */
    public int tSafeupdate(String sql,Object ...params){

        System.out.println("BaseDao 程序正在["+ Thread.currentThread().getName() +"]中");

        // 可能同一变量的多个方法同时调用，结束时还要关闭连接，所以不要把connection连接放到外面
        // QueryRunner 是线程安全的
        Connection connection = DdbcUtils.getTsafeConnection();
        try {
            return qr.update(connection, sql, params);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException(throwables); // 往上抛出异常
        }
    }

    /***
     * 从数据库放回单行 JavaBean对象
     * @param clazz
     * @param sql
     * @param params
     * @param <T>
     * @return
     */
    public <T> T queryForOne(Class<T> clazz ,String sql,Object ...params){
        Connection connection = DdbcUtils.getConnection();
        try {
            return qr.query(connection, sql, new BeanHandler<T>(clazz), params);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException(throwables);
        }
    }

    /***
     * 查询从数据库并放回多行 JavaBean对象
     * @param clazz
     * @param sql
     * @param params
     * @param <T>
     * @return
     */
    public <T> List<T> queryForList(Class<T> clazz , String sql , Object ...params){
        Connection connection = DdbcUtils.getConnection();

        try {
            return qr.query(connection, sql, new BeanListHandler<T>(clazz), params);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException(throwables);
        }
    }

    /***
     * 执行放回一行一列sql语句
     * @param sql
     * @param params
     * @return
     */
    public Object queryForSingleValue(String sql , Object ...params ){
        Connection connection = DdbcUtils.getConnection();
        try {
            return qr.query(connection, sql, new ScalarHandler(), params);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException(throwables);
        }
    }
}
