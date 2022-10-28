package com.whx.pojo;

import java.math.BigDecimal;

/**
 * @author WhitehatXiao
 * @date 2022/10/6
 * @descriptions
 */
public class OrderItem {
    private Integer id;
    private String name ;
    private Integer count;
    private BigDecimal price;
    private BigDecimal totalPrice;
    private String orderid ;

    public OrderItem() {
    }

    public OrderItem(Integer id, String name, Integer count, BigDecimal price, BigDecimal totalPrice, String orderid) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.price = price;
        this.totalPrice = totalPrice;
        this.orderid = orderid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", count=" + count +
                ", price=" + price +
                ", totalPrice=" + totalPrice +
                ", orderid='" + orderid + '\'' +
                '}';
    }
}
