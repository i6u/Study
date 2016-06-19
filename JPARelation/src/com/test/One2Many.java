package com.test;

import com.bean.Order;
import com.bean.OrderItem;
import com.util.Util;
import org.junit.Test;

import javax.persistence.EntityTransaction;
import java.util.UUID;

/**
 * Created by zhouweitao on 16/6/19.
 */
public class One2Many {
    @Test
    public void initDB() {
        Util.getManager();
    }

    @Test
    public void save() {
        EntityTransaction transaction = Util.getManager().getTransaction();
        transaction.begin();

        Order order = new Order();
        order.setAmount(22f);
        order.setOrderId(UUID.randomUUID().toString().substring(0,12));
        OrderItem orderItem1 = new OrderItem();
        orderItem1.setProductName("mike");
        orderItem1.setGetProducPrice(12f);
        order.addOrderItem(orderItem1);
        OrderItem orderItem2 = new OrderItem();
        orderItem2.setProductName("whit");
        orderItem2.setGetProducPrice(11f);
        order.addOrderItem(orderItem2);
        OrderItem orderItem3 = new OrderItem();
        orderItem3.setProductName("banana");
        orderItem3.setGetProducPrice(15f);
        order.addOrderItem(orderItem3);
        Util.getManager().persist(order);
        transaction.commit();
    }
}
