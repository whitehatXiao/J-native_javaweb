package com.whx.dao.impl;

import com.whx.dao.OrderDao;
import com.whx.pojo.Order;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * @author WhitehatXiao
 * @date 2022/10/6
 * @descriptions
 */
public class OrderDaoImplTest {

    OrderDao orderDao = new OrderDaoImpl();

    @Test
    public void saveOrder() {
        // orderDao.saveOrder(new Order("513241561341241", new Date(), new BigDecimal(100), 1, 1));
        // orderDao.saveOrder(new Order("513241561323121", new Date(), new BigDecimal(200), 0, 1));
        // orderDao.saveOrder(new Order("341414124141513", new Date(), new BigDecimal(300), 1, 2));
        // orderDao.saveOrder(new Order("646135151351351", new Date(), new BigDecimal(400), 1, 1));

    }

    @Test
    public void queryAllOrder() {
        System.out.println(orderDao.queryAllOrder());
    }

    @Test
    public void updateOrderStatue() {
        orderDao.updateOrderStatue("513241561323121" ,2 );
        System.out.println(orderDao.queryAllOrder());
    }

    @Test
    public void queryOrderByUserid() {
        System.out.println(orderDao.queryOrderByUserid(1));
    }
}