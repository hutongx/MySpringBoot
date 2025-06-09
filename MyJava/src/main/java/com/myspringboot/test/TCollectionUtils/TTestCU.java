package com.myspringboot.test.TCollectionUtils;

import java.util.List;

public class TTestCU {

    public static void main(String[] args) {
        // CollectionUtils collectionUtils = new CollectionUtils();
        // 使用示例
        List<String> names = CollectionUtils.listOf("张三", "李四", "王五");

        // 过滤出长度大于2的名字
        List<String> longNames = CollectionUtils.filter(names, name -> name.length() >= 2);
        longNames.forEach(System.out::println);

        // 将名字转换为长度
        List<Integer> nameLengths = CollectionUtils.map(names, String::length);
        nameLengths.forEach(System.out::println);
    }
}
