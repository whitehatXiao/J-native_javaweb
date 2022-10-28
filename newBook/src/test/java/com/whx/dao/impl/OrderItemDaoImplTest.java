package com.whx.dao.impl;

import com.whx.dao.OrderItemDao;
import com.whx.pojo.OrderItem;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author WhitehatXiao
 * @date 2022/10/6
 * @descriptions
 */
public class OrderItemDaoImplTest {

    OrderItemDao orderItemDao = new OrderItemDaoImpl();
    @Test
    public void saveOrder() {
        orderItemDao.saveOrder(new OrderItem(null, "水浒传", 2,
                new BigDecimal(100), new BigDecimal(200), "341414124141513"));
        orderItemDao.saveOrder(new OrderItem(null, "三国演义", 2,
                new BigDecimal(100), new BigDecimal(200), "341414124141513"));
        orderItemDao.saveOrder(new OrderItem(null, "红楼梦", 2,
                new BigDecimal(100), new BigDecimal(200), "341414124141513"));
    }

    @Test
    public void queryOrderByDetail() {
        System.out.println(orderItemDao.queryOrderByDetail("341414124141513"));
    }
}