package com.list.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhouweitao on 16/7/22.
 */
public class ArrayListRemove {
    public static void main(String[] args) {
        String testStr = "100,300,400,545,666";

        /**/
        List<String> test = Arrays.asList(testStr.split(","));

        for (String s : test) {
            System.out.println(s);
        }

//        List<String> test = new ArrayList<String>();
//        for(String t : testStr.split(",")){
//            test.add(t);
//        }

//        test.remove("100");
        for (String s : test) {
            System.out.println(s);
        }
    }
}
