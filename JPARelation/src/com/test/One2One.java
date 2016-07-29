package com.test;

import com.bean.IDCard;
import com.bean.Person;
import com.util.Util;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.UUID;

/**
 * Created by zhouweitao on 16/6/19.
 */
public class One2One {
    @Test
    public void initDB() {
        Util.getManager();
        Util.close();
    }

    @Test
    public void save() {
        EntityTransaction transaction = Util.getManager().getTransaction();
        transaction.begin();
        Person person = new Person("老K");
        IDCard idCard = new IDCard(UUID.randomUUID().toString().substring(18));
//        person.setIdCard(idCard);
//        Util.getManager().persist(person);
        idCard.setPerson(person);
        Util.getManager().persist(idCard);
        transaction.commit();
        Util.close();
    }
}
