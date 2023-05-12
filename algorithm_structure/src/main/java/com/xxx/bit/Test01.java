package com.xxx.bit;

import org.junit.Test;

/**
 * 异或运算的妙用
 */
public class Test01 {

    @Test
    public void swap() {
        int a = 12, b = 13;
        //原理：自己异或自己=0，0异或任何数=任何数
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println(a);
        System.out.println(b);
    }

    /*
    问题：一个数组中，只有两个数出现了奇数次，其他数都出现了偶数次，求这两个数        时间复杂度O(n)，空间复杂度O(1)
     */
    public void algorithm01(int[] arr) {
        //第一步，所有元素都异或起来，最后eor=a^b
        int eor = 0;
        for (int cur : arr) {
            eor ^= cur;
        }

        //第二部，有了a^b，怎么分开呢。答案是找到其中任意一个。因为a和b不是同一个数，必定会有一位是不同的，体现在eor中就是必有一位是1
        int RightOne = eor & (~eor + 1);//解释，eor取反末尾加一再和eor与，可以得到最右边的一个1，其他位全部变0。就得到了a和b起码在这一位上一个是0一个是1

        //第三步，再异或一次，这次不全上
        int eor_1 = 0;
        for (int cur : arr) {
            if ((cur & RightOne) == 0)//这一步就是判断当前的数是否属于一类（这一类里面只包含a或者b），也可以判断(cur & RightOne) == RightOne
                eor_1 ^= cur;
        }

        System.out.println(eor_1 + " + " + (eor ^ eor_1));

    }

}
