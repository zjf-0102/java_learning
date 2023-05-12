package com.nuist;

import org.junit.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;

/*
    IO流
*/
public class IOStream {
    public static void main(String[] args) {
        int readContent = 0;
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("D:\\审稿\\接受的一句话.txt");
            while ((readContent = fileInputStream.read()) != -1){
                System.out.print((char)readContent);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    void readByByteArray(){
        //每次读取8个字节存到bytes数组中
        byte[] bytes = new byte[8];
        //每次读取的有效长度
        int ReadLength = 0;
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("D:\\审稿\\接受的一句话.txt");
            while ((ReadLength = fileInputStream.read(bytes)) != -1){
                System.out.print(new String(bytes, 0, ReadLength));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /*
    输出流类似，write('H')或者write(String.getBytes(bytes))
    但是打开输出流时可以写成FileOutputStream("文件名",true)第二个参数表示写入时是添加而不是覆盖
     */

    /*
    FileReader和FileWriter同理。
    注意：写入文件时最后要关闭字符流才会写入进去
     */

    /*
    上面这四个都是节点流
     */

    /*
    BufferedReader,BufferedWriter,BufferedInputStream,BufferedOutputStream 等是处理流（修饰者模式）
     */

    /*
    同时保存值和数据类型——>序列化  ObjectOutputStream
    恢复值和数据类型——>反序列化    ObjectInputStream
    注：
    如果属性有static或者transient修饰，则该属性不可序列化
    序列化的类中的每个属性都必须是可序列化的
    序列化的类的子类默认是可序列化的
     */

    /*
    InputStreamReader和OutputStreamWriter
    转换流：解决乱码问题
    属于Reader的子类，可以指定读取时的编码方式，把 字节流 包装成 字符流
     */
    void transformation(){
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("文件名"), StandardCharsets.UTF_8));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
