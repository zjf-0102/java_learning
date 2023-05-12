package com.nuist;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Map包括
 *      HashMap     线程不安全
 *              LinkedHashMap(子类) 有序
 *      TreeMap     排序
 *      HashTable   线程安全
 *              Properties(子类)
 */
@SuppressWarnings("all")
public class MyMap {
    public static void main(String[] args) {

        //HashMap底层和HashSet一样，前面HashSet源码讲了，只不过value变成了用户指定的
        Map map = new HashMap();
        map.put("no1", "张无忌");
        map.put("no2", "赵敏");

        //另外为了方便管理，HashMap将每个HashMap$Node封装成一个entry存到entryset中，可以通过getKey和getValue分别获得key和value
        Set entrySet = map.entrySet();
        for (Object obj : entrySet) {
            Map.Entry entry = (Map.Entry) obj;
            entry.getKey();
            entry.getValue();
        }

        //另外也可以通过KetSet和values获得所有key和value
        Set set = map.keySet();
        Collection values = map.values();



    }
}
