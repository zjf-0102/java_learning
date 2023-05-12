package com.nuist;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * set包括
 *      HashSet                     数组+链表+红黑树
 *      LinkedHashSet(子类)    数组+双向链表（有序!!!）
 *      TreeSet                 排序
 */
@SuppressWarnings("all")
public class MySet {

    public static void main(String[] args) {

        class Dog {
            private String name;

            public Dog(String name) {
                this.name = name;
            }
        }

        //虽然set是无序的，但是可以发现他取出来时是按一定顺序取出的不会变化
        //HashSet其实是HashMap—（源码）   HashSet只用了key，value默认一个静态值不变

        //存放是数组+链表+红黑树
        //  初始数组16，当达到临界值12（元素个数）时扩容2倍，变为32，临界值24（元素个数），以此类推
        //  当挂载的链长达到8时，判断数组是否为最大值64
        //      如果是64.树化
        //      如果不是，扩容
        Set set = new HashSet();

        //这里和下面比较，首先他俩不会存到同一位置。即使同一位置因为没有重写equals，只会判断地址，而地址不同，判断为不同对象，可以添加
        set.add(new Dog("小黄"));
        set.add(new Dog("小黄"));

        //解释：按理来说不同的对象肯定是加不进去的，但是
        //      String重写了hashcode和equals方法
        //          重写的hashcode保证值一样的String对象得到的hashcode一样，从而存到数组中的同一位置上
        //          重写的equals保证值一样的对象，通过equals判断会得到true，从而导致添加失败
        set.add(new String("java"));
        set.add(new String("java"));

        System.out.println(set);


        //可传入实现了comparator接口的对象
        Set treeSet = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((String) o1).compareTo((String) o2);
            }
        });
        treeSet.add("a");
        treeSet.add("b");
        treeSet.add("c");
        treeSet.add("d");
        treeSet.add("e");

        //神奇现象，如果把比较方式改成字符串长度比较就只能加入一个元素，因为长度都为1判定是相同元素无法加入到set中
        treeSet = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((String) o1).length() - ((String) o2).length();
            }
        });
        treeSet.add("a");
        treeSet.add("b");
        treeSet.add("c");
        treeSet.add("d");
        treeSet.add("e");


        /*
        HashSet和TreeSet的去重机制不同
            HashSet用hashcode和equals
            TreeSet用comparator
         */

    }
}


