package com.whx.dao.impl;

import com.whx.dao.OrderItemDao;
import com.whx.pojo.OrderItem;

/**
 * @author WhitehatXiao
 * @date 2022/9/29
 * @descriptions
 */
public class OrderItemDaoImpl extends BaseDao implements OrderItemDao {

    @Override
    public void saveOrderItem(OrderItem orderItem) {
        System.out.println("OrderItemDaoImpl 正在程序 ["+ Thread.currentThread().getName()+"] 中");

        String sql = "INSERT into t_order_item( `id` , `name`,`count`,`price`,`total_price`,`order_id`) " +
                "VALUES(?,?,?,?,?,?)";
        try {
            tSafeupdate(sql, orderItem.getId(),orderItem.getName(),orderItem.getCount(),orderItem.getPrice(),
                    orderItem.getTotal_price(),orderItem.getOrder_id());
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }
}
