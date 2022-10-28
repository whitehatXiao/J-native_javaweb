package com.whx.service;

import com.whx.pojo.Cart;

/**
 * @author WhitehatXiao
 * @date 2022/9/29
 * @descriptions
 */
public interface OrderService {

    /**
     * 生成订单
     * @param cart
     * @param userId
     * @return
     */
    public  String createOrder(Cart cart , Integer userId );
}
