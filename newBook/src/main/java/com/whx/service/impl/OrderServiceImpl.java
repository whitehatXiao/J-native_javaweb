package com.whx.service.impl;

import com.whx.dao.OrderDao;
import com.whx.dao.OrderItemDao;
import com.whx.dao.impl.OrderDaoImpl;
import com.whx.dao.impl.OrderItemDaoImpl;
import com.whx.pojo.Cart;
import com.whx.pojo.CartItem;
import com.whx.pojo.Order;
import com.whx.pojo.OrderItem;
import com.whx.service.OrderService;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author WhitehatXiao
 * @date 2022/10/6
 * @descriptions
 */
public class OrderServiceImpl  implements OrderService {

    private OrderDao orderDao = new OrderDaoImpl();
    private OrderItemDao orderItemDao = new OrderItemDaoImpl();

    @Override
    public String createOrder(Cart cart, Integer userId) {

        String seed =System.currentTimeMillis() + "";
        String orderId = Math.abs(seed.hashCode() ) + "" + userId;



        Order order = new Order(orderId, new Date(), cart.getTotalPrice(), 0, userId);

        orderDao.saveOrder(order);

        for (Map.Entry<Integer, CartItem> entry : cart.getItems().entrySet()) {
            CartItem cartItem = entry.getValue();
            OrderItem orderItem =
                    new OrderItem(cartItem.getId(), cartItem.getName(), cartItem.getCount(),
                    cartItem.getPrice(), cartItem.getTotalPrice(), orderId);
            orderItemDao.saveOrder(orderItem);
        }

        cart.clear();
        return orderId;
    }

    @Override
    public List<Order> showAllOrder() {
        return null;
    }

    @Override
    public void sendOrder(String orderid) {

    }

    @Override
    public List<OrderItem> showOrderDetail(String orderid) {
        return orderItemDao.queryOrderByDetail(orderid);
    }

    @Override
    public List<Order> showMyOrders(Integer userid) {
        return orderDao.queryOrderByUserid(userid);
    }

    @Override
    public void receiverOrder(String orderid , Integer status) {
        orderDao.updateOrderStatue(orderid , status);
    }
}
