package com.test;

import com.util.Util;
import org.junit.Test;

/**
 * Created by zhouweitao on 16/6/19.
 */
public class One2One {
    @Test
    public void initDB() {
        Util.getManager();
        Util.close();
    }
}
