package com.whx.dao;

import com.whx.pojo.Order;

/**
 * @author WhitehatXiao
 * @date 2022/9/29
 * @descriptions
 */
public interface OrderDao {

    /**
     * 保存订单
     * @param order
     */
    public void saveOrder(Order order) ;


}
