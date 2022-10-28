package com.whx.dao.impl;

import com.whx.dao.OrderDao;
import com.whx.pojo.Order;
import com.whx.pojo.OrderItem;

import java.lang.annotation.Annotation;

/**
 * @author WhitehatXiao
 * @date 2022/9/29
 * @descriptions
 */
public class OrderDaoImpl extends BaseDao implements OrderDao {


    @Override
    public void saveOrder(Order order) {

        System.out.println(" OrderDaoImpl 程序正在[ "+ Thread.currentThread().getName()+" ]中");

        String sql = "insert into t_order (`order_id`,`create_time`,`price`,`status`,`user_id`)" +
                " values(?,?,?,?,?)";

        try {
            tSafeupdate(sql, order.getOrder_id(),order.getCreate_time(),order.getPrice(),order.getStatus(),order.getUser_id());
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }


}

