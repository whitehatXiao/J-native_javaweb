package com.whx.test;

import com.whx.dao.OrderDao;
import com.whx.dao.impl.OrderDaoImpl;
import com.whx.pojo.Order;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * @author WhitehatXiao
 * @date 2022/9/29
 * @descriptions
 */
public class OrderDaoTest {

    OrderDao orderDao = new OrderDaoImpl();


    @Test
    public void saveOrder() {
        orderDao.saveOrder(new Order("123456", new Date(), new BigDecimal(101.11), 0, 1));
    }
}