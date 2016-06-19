package com.bean;

import javax.persistence.*;

/**
 * Created by zhouweitao on 16/6/19.
 * 订单项
 */
@Entity
@Table(name = "t_orderItem")
public class OrderItem {
    private Integer id;
    private String productName;
    private Float getProducPrice = 0f;
    private Order order;

    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.REFRESH},optional = false)//cascade设置级联操作,optional设置是否可以为空
    @JoinColumn(name = "orderId")//设置外键名称
    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Id
    @GeneratedValue
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(length = 40, nullable = false)
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Column(nullable = false)
    public Float getGetProducPrice() {
        return getProducPrice;
    }

    public void setGetProducPrice(Float getProducPrice) {
        this.getProducPrice = getProducPrice;
    }
}
