package com.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by zhouweitao on 16/6/16.
 */
public class Util {
    private final static EntityManagerFactory factory = Persistence.createEntityManagerFactory("study");
    private final static EntityManager manager = factory.createEntityManager();
    public static void close() {
        if (manager !=null) manager.close();
        if (factory !=null) factory.close();
    }

    public static EntityManager getManager() {
        return manager;
    }
}
