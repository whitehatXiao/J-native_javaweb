package com.whx.pojo;

import java.math.BigDecimal;

/**
 * @author WhitehatXiao
 * @date 2022/9/28
 * @descriptions 购物车商品项
 */
public class CartItem {

    private Integer id ;
    private String name ;
    private BigDecimal price;
    private BigDecimal totalPrice;
    private Integer count;

    public CartItem() {
    }

    public CartItem(Integer id, String name, Integer count , BigDecimal price, BigDecimal totalPrice) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.totalPrice = totalPrice;
        this.count = count;
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

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.totalPrice = totalPrice.multiply(new BigDecimal(count));
        this.count = count;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", totalPrice=" + totalPrice +
                ", count=" + count +
                '}';
    }
}
