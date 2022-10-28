package com.whx.test;

import com.whx.pojo.Cart;
import com.whx.pojo.CartItem;
import com.whx.service.OrderService;
import com.whx.service.impl.OrderServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author WhitehatXiao
 * @date 2022/9/29
 * @descriptions
 */
public class OrderServiceImplTest {

    @Test
    public void createOrder() {

        Cart cart = new Cart();
        cart.addItem(new CartItem(1, "java从入门到精通", 1, new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(1, "java从入门到精通", 1, new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(2, "数据结构与算法", 1, new BigDecimal(100),new BigDecimal(100)));

        OrderService orderService = new OrderServiceImpl();
        System.out.println( "订单号是：" + orderService.createOrder(cart, 1) );

    }
}