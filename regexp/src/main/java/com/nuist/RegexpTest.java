package com.nuist;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexpTest {

    public static void main(String[] args) {

        String content = "hello1999你好!";
        String content2 = "123s";

//        Pattern pattern = Pattern.compile("[0-9]+");
//        Pattern pattern = Pattern.compile("[a-zA-Z]+");
        Pattern pattern = Pattern.compile("^\\d+$");
        Matcher matcher = pattern.matcher(content2);
        while (matcher.find()){
            //return getSubSequence(groups[group * 2], groups[group * 2 + 1]).toString();
            //                               0                  0
            //底层groups数组中
            // groups[0]存的是匹配到的字符的开始索引
            // groups[1]存的是匹配到的字符的结束索引
            System.out.println(matcher.group(0));
        }

    }

    /*
      正则表达式中的元字符
      转义符： \\

     */

}
