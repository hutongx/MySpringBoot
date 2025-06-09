package com.myspringboot.test;

import java.util.ArrayList;
import java.util.List;

public class ERRTest {
    public static void main(String[] args) {
        // 数组是协变的，这可能导致运行时错误
        Object[] objects = new String[3]; // 编译通过
        objects[0] = "hello"; // 运行正常
        objects[1] = 123;     // 运行时抛出ArrayStoreException！

        // 泛型是不变的，这在编译时就能发现问题
        // List<Object> objects1 = new ArrayList<String>(); // 编译错误！
    }
}
