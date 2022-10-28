package com.whx.dao;

import com.whx.pojo.OrderItem;

/**
 * @author WhitehatXiao
 * @date 2022/9/29
 * @descriptions
 */
public interface OrderItemDao {

    /**
     * 保存详细订单内容
     * @param orderItem
     */
    public void saveOrderItem(OrderItem orderItem );
}
