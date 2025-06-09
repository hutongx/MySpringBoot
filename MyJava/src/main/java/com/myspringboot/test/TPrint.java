package com.myspringboot.test;

import java.util.Arrays;
import java.util.List;

public class TPrint {

    // 我想写一个方法，能打印任何类型的List
    public void printList(List<?> list) {
        for (Object item : list) {
            System.out.println(item);
        }
    }

    public static void main(String[] args) {
        TPrint tPrint = new TPrint();
        // 这样就可以打印任何List了
        List<String> stringList = Arrays.asList("a", "b", "c");
        List<Integer> intList = Arrays.asList(1, 2, 3);

        tPrint.printList(stringList); // 打印字符串列表
        tPrint.printList(intList);    // 也可以
    }
}
