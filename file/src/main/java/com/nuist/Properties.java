package com.nuist;

import org.junit.Test;

import java.io.IOException;

public class Properties {
    public static void main(String[] args) {



    }

    @Test
    public void testProperties(){
        try {
            //创建对象
            java.util.Properties properties = new java.util.Properties();
            //加载要读取的文件
            //properties.load(new FileReader("D:\\Code\\java_learning\\file\\src\\main\\resources\\Mysql.properties"));
            properties.load(this.getClass().getClassLoader().getResourceAsStream("Mysql.properties"));
            //读取
            System.out.println(properties.getProperty("ip"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
