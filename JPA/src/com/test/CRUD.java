package com.test;

import com.bean.Gender;
import com.bean.User;
import com.util.Util;
import org.junit.Test;
import javax.persistence.EntityTransaction;
import java.util.Date;

/**
 * Created by zhouweitao on 16/6/16.
 */
public class CRUD {
    private EntityTransaction transaction;
    @Test
    public void save() {
        transaction = Util.getManager().getTransaction();
        transaction.begin();
        User u = new User("e",new Date());
        u.setGender(Gender.WOMEN);
        Util.getManager().persist(u);
        transaction.commit();
        Util.close();
    }

    @Test
    public void load() {
        System.out.println(Util.getManager().find(User.class,1).toString());
    }
}
