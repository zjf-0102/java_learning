package com.nuist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Collection包括
 *      list
 *      set
 * Map包括
 *      map
 *
 *
 * List包括
 *      ArrayList    线程不安全，底层数组
 *      LinkedList   双向链表
 *      Vector       线程安全
 */
public class MyList {
    @SuppressWarnings("all")
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("first");
        list.add("second");
        list.add("third");
        list.add("forth");
        list.add("fifth");

        //用迭代器遍历，快捷键==>itit
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Object next =  iterator.next();
            System.out.println(next);
        }
    }
}
