package com.whx.service;

import com.whx.pojo.Cart;
import com.whx.pojo.Order;
import com.whx.pojo.OrderItem;

import java.util.List;

/**
 * @author WhitehatXiao
 * @date 2022/10/6
 * @descriptions
 */
public interface OrderService {

    public String createOrder(Cart cart , Integer userId);

    public List<Order> showAllOrder();

    public void sendOrder(String orderid);

    public List<OrderItem> showOrderDetail(String orderid);

    public List<Order>  showMyOrders(Integer userid);

    public void receiverOrder(String orderid , Integer status);

}
