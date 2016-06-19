package com.test;

import com.bean.Gender;
import com.bean.User;
import com.util.Util;
import org.junit.Test;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.io.*;
import java.util.Date;
import java.util.List;

/**
 * Created by zhouweitao on 16/6/16.
 */
public class CRUD {
    private EntityTransaction transaction;

    @Test
    public void initDB() {
        Util.getManager();
    }
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

    @Test
    public void merge() {
    }

    @Test
    public void saveByte() {
        File file = new File("/Users/zhouweitao/Pictures/PhotoShop/a.png");
        byte[] temp = new byte[0];
        try {
            FileInputStream inputStream = new FileInputStream(file);
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            int i;
            while ((i = inputStream.read()) != -1) {
                outputStream.write(i);
            }
            inputStream.close();
            temp = outputStream.toByteArray();
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        User u = new User();
        u.setName("zhou");
        u.setPic(temp);
        u.setBirthday(new Date());
        transaction = Util.getManager().getTransaction();
        transaction.begin();
        Util.getManager().persist(u);
        transaction.commit();

    }

    @Test
    public void getUser() {//类似hibernate的get方法,立即加载
        User user = Util.getManager().find(User.class, 1);
        System.out.println("user = " + user);
    }

    @Test
    public void getReference() {//类似hibernate的load方法,延时加载
        User user = Util.getManager().getReference(User.class, 1);
        System.out.println("user = " + user);
    }

    @Test
    public void setReference() {//类似hibernate的load方法,延时加载
        EntityTransaction transaction = Util.getManager().getTransaction();
        transaction.begin();
        User user = Util.getManager().getReference(User.class, 1);
//        user.setName("abcder");
//        Util.getManager().clear();
        Util.getManager().merge(user);
        Util.getManager().remove(user);
        transaction.commit();
        System.out.println("user2 = " + user);
    }

    @Test
    public void query1() {
        Query query = Util.getManager().createQuery("select u from User u where u.id=?1");
        query.setParameter(1, 2);
        System.out.println(query.getSingleResult());
    }

    @Test
    public void query2() {
        Query query = Util.getManager().createQuery("from User u where u.id=?1");
        query.setParameter(1, 2);
        System.out.println(query.getSingleResult());
    }

    @Test
    public void query3() {
        Query query = Util.getManager().createQuery("from User");
        List<User> list = query.getResultList();
        for (User user : list) {
            System.out.println(user);
        }
    }

    @Test
    public void queryDelete() {
        EntityTransaction transaction = Util.getManager().getTransaction();
        transaction.begin();
        Query query = Util.getManager().createQuery("delete from User u where u.id=?1");
        query.setParameter(1, 2);
        int temp = query.executeUpdate();
        System.out.println(temp);
        transaction.commit();
    }

    @Test
    public void queryUpdate() {
        EntityTransaction transaction = Util.getManager().getTransaction();
        transaction.begin();
        Query query = Util.getManager().createQuery("update User u set u.name=?1 where u.id=?2");
        query.setParameter(2, 3);
        query.setParameter(1, "mysql");
        int temp = query.executeUpdate();
        transaction.commit();
        System.out.println("temp = " + temp);
    }
}
