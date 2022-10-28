package com.whx.service.impl;

import com.whx.dao.BookDao;
import com.whx.dao.OrderDao;
import com.whx.dao.OrderItemDao;
import com.whx.dao.impl.BookDaoImpl;
import com.whx.dao.impl.OrderDaoImpl;
import com.whx.dao.impl.OrderItemDaoImpl;
import com.whx.pojo.*;
import com.whx.service.OrderService;

import java.util.Date;
import java.util.Map;

/**
 * @author WhitehatXiao
 * @date 2022/9/29
 * @descriptions
 */
public class OrderServiceImpl implements OrderService {

    private OrderDao orderDao = new OrderDaoImpl();
    private OrderItemDao orderItemDao = new OrderItemDaoImpl();
    private BookDao bookDao = new BookDaoImpl();

    @Override
    public String createOrder(Cart cart, Integer userId) throws RuntimeException{

        System.out.println("OrderServiceImpl正在程序["+Thread.currentThread().getName()+"]中 ");

        // 订单号===唯一性
        String orderId = System.currentTimeMillis()+""+userId;
// 创建一个订单对象
        Order order = new Order(orderId,new Date(),cart.getTotalPrice(), 0,userId);
// 保存订单
        orderDao.saveOrder(order);
// 遍历购物车中每一个商品项转换成为订单项保存到数据库

        for (Map.Entry<Integer, CartItem>entry : cart.getItems().entrySet()){
// 获取每一个购物车中的商品项
            CartItem cartItem = entry.getValue();
// 转换为每一个订单项
            OrderItem orderItem = new
                    OrderItem(null,cartItem.getName(),cartItem.getCount(),cartItem.getPrice(),cartItem.getTotalPrice(),
                    orderId);
// 保存订单项到数据库
            orderItemDao.saveOrderItem(orderItem);

            // 在创建订单时（ 也就是结账时，相应的改变库存和销量
            Book book = bookDao.QueryBookById(cartItem.getId());
            book.setStock( book.getStock() - cartItem.getCount() );
            book.setSales( book.getSales() + cartItem.getCount() );
            bookDao.updateBook(book);
        }
// 清空购物车
        cart.clear();
        return orderId;
    }



}
