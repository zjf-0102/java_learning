package com.nuist;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class FileCreate {

        @Test
        public void fileCreate() {

        File file = new File("E:\\", "test1.txt");
        try {
//          调用了方法之后才会创建文件
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
