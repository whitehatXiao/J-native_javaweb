package com.whx.pojo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author WhitehatXiao
 * @date 2022/10/6
 * @descriptions
 */
public class Order {

    private String orderId ;
    private Date createTime;
    private BigDecimal price;
    private Integer status ;
    private Integer userid ;

    public Order() {
    }

    public Order(String orderId, Date createTime, BigDecimal price, Integer status, Integer userid) {
        this.orderId = orderId;
        this.createTime = createTime;
        this.price = price;
        this.status = status;
        this.userid = userid;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", createTime=" + createTime +
                ", price=" + price +
                ", status=" + status +
                ", userid=" + userid +
                '}';
    }
}
