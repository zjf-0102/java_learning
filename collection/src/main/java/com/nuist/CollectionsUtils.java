package com.nuist;

import java.util.*;

/**
 * Collections工具类
 */
@SuppressWarnings("all")
public class CollectionsUtils {
    public static void main(String[] args) {

        List arrayList = new ArrayList();
        arrayList.add("tom");
        arrayList.add("jack");
        arrayList.add("mary");
        arrayList.add("smith");

//        翻转
        Collections.reverse(arrayList);
//        打乱
        Collections.shuffle(arrayList);
//        排序
        Collections.sort(arrayList);
        Collections.sort(arrayList, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((String) o1).length() - ((String) o2).length();
            }
        });
//        交换
        Collections.swap(arrayList, 0, 1);
//        最大值，可加比较器
        Collections.max(arrayList);
//        统计元素出现次数
        Collections.frequency(arrayList, "tom");
//        拷贝，第一个是目标数组，第二个是原数组
//        替换
        Collections.replaceAll(arrayList, "tom", "newTom");

    }
}
