package com.whx.pojo;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author WhitehatXiao
 * @date 2022/10/6
 * @descriptions
 */
public class CartItemTest {
    @Test
    public void test1(){
        CartItem cartItem = new CartItem(1, "水浒传", 2, new BigDecimal(88));
        System.out.println(cartItem.getTotalPrice());
    }

}