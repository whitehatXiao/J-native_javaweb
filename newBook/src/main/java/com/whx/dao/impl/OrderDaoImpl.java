package com.whx.dao.impl;

import com.whx.dao.OrderDao;
import com.whx.pojo.Order;

import java.util.List;

/**
 * @author WhitehatXiao
 * @date 2022/10/6
 * @descriptions
 */
public class OrderDaoImpl extends BaseDaoImpl implements OrderDao {

    @Override
    public void saveOrder(Order order) {
        String sql = "insert into t_order values(?,?,?,?,?)";
        update(sql, order.getOrderId(),order.getCreateTime(),order.getPrice(),order.getStatus(),
                order.getUserid());
    }

    @Override
    public List<Order> queryAllOrder() {
        String sql = "select * from t_order";
        return queryForList(Order.class, sql);
    }

    @Override
    public void updateOrderStatue(String orderID, Integer status) {
        String sql = "update t_order set status=? where orderid = ?";
        update(sql, status , orderID);
    }

    @Override
    public List<Order> queryOrderByUserid(Integer userid) {
        String sql = "select * from t_order where userid = ?";
        return queryForList(Order.class, sql, userid);
    }
}
