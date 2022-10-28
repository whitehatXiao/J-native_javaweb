package com.whx.pojo;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author WhitehatXiao
 * @date 2022/10/6
 * @descriptions
 */
public class CartTest {

    @Test
    public void addItem() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1, "java从入门到精通", 1, new BigDecimal(1000)));
        cart.addItem(new CartItem(1, "java从入门到精通", 1, new BigDecimal(1000)));
        cart.addItem(new CartItem(2, "数据结构与算法", 1, new BigDecimal(100)));
        System.out.println(cart);

    }

    @Test
    public void deleteItem() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1, "java从入门到精通", 1, new BigDecimal(1000)));
        cart.addItem(new CartItem(1, "java从入门到精通", 1, new BigDecimal(1000)));
        cart.addItem(new CartItem(2, "数据结构与算法", 1, new BigDecimal(100)));
        System.out.println(cart);
        System.out.println("===============");
        cart.deleteItem(1);
        System.out.println(cart);
    }

    @Test
    public void clear() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1, "java从入门到精通", 1, new BigDecimal(1000)));
        cart.addItem(new CartItem(1, "java从入门到精通", 1, new BigDecimal(1000)));
        cart.addItem(new CartItem(2, "数据结构与算法", 1, new BigDecimal(100)));
        System.out.println(cart);
        System.out.println("===============");
        cart.clear();
        System.out.println(cart);
    }

    @Test
    public void updateCount() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1, "java从入门到精通", 1, new BigDecimal(1000)));
        cart.addItem(new CartItem(1, "java从入门到精通", 1, new BigDecimal(1000)));
        cart.addItem(new CartItem(2, "数据结构与算法", 1, new BigDecimal(100)));
        System.out.println(cart);
        System.out.println("===============");
        cart.updateCount(2, 20);
        System.out.println(cart);
    }

    @Test
    public void getTotalCount() {
    }

    @Test
    public void getTotalPrice() {
    }
}