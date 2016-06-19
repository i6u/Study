package com.bean;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by zhouweitao on 16/6/19.
 * 订单
 */
@Entity
@Table(name = "t_order")
public class Order {
    private String orderId;
    private Float amount;
    private Set<OrderItem> items = new HashSet<OrderItem>();



    @OneToMany(cascade = {CascadeType.REFRESH,CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE},fetch = FetchType.LAZY,mappedBy = "order")
    //fetch设置延迟加载(如果关联的是多的一方,那么一的一方默认就是延迟加载,可以不写),mappedBy设置由对方维护关系(属性内容为声明在关系维护方中被维护关系方的属性名)
    public Set<OrderItem> getItems() {
        return items;
    }

    public void setItems(Set<OrderItem> items) {
        this.items = items;
    }

    @Id
    @Column(length = 12)
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    @Column(nullable = false)
    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public void addOrderItem(OrderItem orderItem) {
        orderItem.setOrder(this);
        this.items.add(orderItem);
    }
}
