package com.whx.dao;

import com.whx.pojo.Order;
import com.whx.pojo.OrderItem;

import java.util.List;

/**
 * @author WhitehatXiao
 * @date 2022/10/6
 * @descriptions
 */
public interface OrderItemDao {

    public void saveOrder(OrderItem orderItem) ;

    public List<OrderItem> queryOrderByDetail(String orderid) ;
}
