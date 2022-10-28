package com.whx.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author WhitehatXiao
 * @date 2022/9/20
 * @descriptions 数据库连接池 ： Dirver驱动 + Druid连接池
 */


public class newDdbUtils {

    private static DruidDataSource dataSource;
    private static ThreadLocal<Connection> conns
            = new ThreadLocal<>();   // 线程域


    static {
        Properties properties = new Properties();

        try {

            // 读取 jdbc.properties 属性配置文件
            //
            //  // 方式一 :  类加载方式不行，问题待查  ; 已近排错出来了，式需要放在 resources 上
            InputStream in = newDdbUtils.class.getClassLoader()
                    .getResourceAsStream("jdbc.properties");
            properties.load(in);


            // 方式二：
            // properties.load(new FileInputStream("D:\\A-JavaWeb\\Projects\\JavaWeb\\BookProject\\src\\jdbc.properties"));
            // 从流种加载属性配置
            // 创建数据库连接池
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
//
            System.out.println(dataSource);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // public static void main(String[] args) {
    //
    // }
    /**
     * 获数据库连接，非事务安全的
     * @return 如果返回 null,说明获取连接失败<br/>有值就是获取连接成功
     */
    public static Connection getConnection(){
        Connection conn = null;
        try {
            conn = (Connection)dataSource.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return conn;
    }



    /**
     * 获取数据库连接池中的事务安全连接 ,  事务连接....
     * @return 如果返回 null,说明获取连接失败<br/>有值就是获取连接成功
     */
    public static Connection getTsafeConnection(){
        Connection conn = conns.get();
        if (conn == null) {
            try {
                conn = dataSource.getConnection();//从数据库连接池中获取连接
                conns.set(conn); // 保存到 ThreadLocal 对象中，供后面的 jdbc 操作使用
                conn.setAutoCommit(false); // 设置为手动管理事务
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return conn;
    }


    /***
     * 关闭连接，放回数据库连接池 ； 非事务连接
     * @param conn
     */
    public static void close(Connection conn) {

        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }


    /**
     * 提交事务，并关闭释放连接
     */
    public static void commitAndClose(){
        Connection connection = conns.get();
        if (connection != null) { // 如果不等于 null，说明 之前使用过连接，操作过数据库
            try {
                connection.commit(); // 提交 事务
            } catch (SQLException e) {
                e.printStackTrace(); // 如果 commmit() 这一阶段出现异常，就没有必要向上Servlet(Web)层抛出异常了，执行conn.close()就行 ，但是异常栈还是需要记录得
            } finally {
                try {
                    connection.close(); // 关闭连接，资源资源
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
// 一定要执行 remove 操作，否则就会出错。（因为 Tomcat 服务器底层使用了线程池技术）!!!!
        conns.remove();
    }

    /**
     * 回滚事务，并关闭释放连接
     */
    public static void rollbackAndClose(){
        Connection connection = conns.get();
        if (connection != null) { // 如果不等于 null，说明 之前使用过连接，操作过数据库
            try {
                connection.rollback();//回滚事务 ， 和 commitAndClose() 高度类似， 只是 commit 和 rollback的 这行操作不同，
                //    同时也不用抛出异常，这时最底层的连接操作了，捕捉到异常直接关闭就好乱
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    connection.close(); // 关闭连接，资源资源
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
// 一定要执行 remove 操作，否则就会出错。（因为 Tomcat 服务器底层使用了线程池技术）
        conns.remove();
    }





    /***
     * 获取数据源
     * @return
     */
    public static DataSource getDataSource(){
        return dataSource;
    }


    /**
     *  释放连接
     * @param resultSet 结果集
     * @param preparedStatement  游标对象
     * @param conn 连接对象
     */
//    public static void freeConnect(ResultSet resultSet, PreparedStatement preparedStatement, Connection conn) {
//        try {
//            if (resultSet != null) resultSet.close();
//            if (preparedStatement != null) preparedStatement.close();
//            if (conn != null) conn.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }



}