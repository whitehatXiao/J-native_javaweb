package com.whx.dao.impl;

import com.alibaba.druid.sql.ast.SQLKeep;
import com.whx.dao.OrderItemDao;
import com.whx.pojo.Order;
import com.whx.pojo.OrderItem;

import java.util.List;

/**
 * @author WhitehatXiao
 * @date 2022/10/6
 * @descriptions
 */
public class OrderItemDaoImpl extends BaseDaoImpl implements OrderItemDao {

    @Override
    public void saveOrder(OrderItem orderItem) {
        String sql = "insert into t_orderitems value(?,?,?,?,?,?)";
        update(sql, orderItem.getId(),orderItem.getName(),orderItem.getCount()
        ,orderItem.getPrice(),orderItem.getTotalPrice(),orderItem.getOrderid());
    }

    @Override
    public List<OrderItem> queryOrderByDetail(String orderid) {
        String sql = "select * from t_orderitems where orderid = ?";
        return queryForList(OrderItem.class, sql, orderid);
    }
}
