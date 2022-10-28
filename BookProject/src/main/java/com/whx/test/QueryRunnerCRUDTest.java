package com.whx.test;

/**
 * @author WhitehatXiao
 * @date 2022/9/20
 * @descriptions  使用dbutils框架的QueryRunner类完成CRUD,以及批处理
 */
public class QueryRunnerCRUDTest {

    /*
     *---------测试表Start--------------------
     create table users(
         id int primary key auto_increment,
         name varchar(40),
         password varchar(40),
         email varchar(60),
         birthday date
     );
     *---------测试表end--------------------
     */
//    @Test
//    public void add() throws SQLException {
//        //将数据源传递给QueryRunner，QueryRunner内部通过数据源获取数据库连接
//        DataSource dataSource = JdbcUtils.getDataSource();
//        System.out.println(dataSource);
//        QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
//        String sql = "insert into users(name,password,email,birthday) values(?,?,?,?)";
//        Object params[] = {"蛙课网","123", "wkcto@163.com", new Date()};
//        //Object params[] = {"蛙课","123", "wkcto@163.com", "1989-08-09"};
//        qr.update(sql, params);
//    }



}
