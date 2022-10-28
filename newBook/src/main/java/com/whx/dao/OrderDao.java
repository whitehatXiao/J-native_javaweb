package com.whx.dao;

import com.whx.pojo.Cart;
import com.whx.pojo.Order;

import java.util.List;

/**
 * @author WhitehatXiao
 * @date 2022/10/6
 * @descriptions
 */
public interface OrderDao {

    public void saveOrder(Order order);

    public List<Order> queryAllOrder();

    public void updateOrderStatue(String orderID , Integer status );

    public List<Order> queryOrderByUserid(Integer userid);



}
