package com.test;

import com.bean.AirLine;
import com.util.Util;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 * Created by zhouweitao on 16/6/20.
 */
public class CompositePK {
    @Test
    public void testPK() {
        EntityManager em = Util.getManager();
        EntityTransaction transaction = Util.getManager().getTransaction();
        transaction.begin();
        em.persist(new AirLine("PEK","CAN","北京-fly-深圳"));
        transaction.commit();
        Util.close();
    }
}
