package com.whx.service.impl;

import com.whx.pojo.Cart;
import com.whx.pojo.CartItem;
import com.whx.service.OrderService;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author WhitehatXiao
 * @date 2022/10/6
 * @descriptions
 */
public class OrderServiceImplTest {

    OrderService orderService = new OrderServiceImpl();

    @Test
    public void createOrder() {

        Cart cart = new Cart();
        cart.addItem(new CartItem(1, "java从入门到精通", 1, new BigDecimal(1000)));
        cart.addItem(new CartItem(1, "java从入门到精通", 1, new BigDecimal(1000)));
        cart.addItem(new CartItem(2, "数据结构与算法", 1, new BigDecimal(100)));


        System.out.println( "订单号是：" + orderService.createOrder(cart, 1) );


    }

    @Test
    public void showAllOrder() {
    }

    @Test
    public void sendOrder() {
    }

    @Test
    public void showOrderDetail() {
    }

    @Test
    public void showMyOrders() {
        System.out.println(orderService.showMyOrders(1));
    }

    @Test
    public void receiverOrder() {
    }
}