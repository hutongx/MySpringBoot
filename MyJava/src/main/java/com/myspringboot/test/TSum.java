package com.myspringboot.test;

import java.util.Arrays;
import java.util.List;

public class TSum {

    // 假设你想写一个方法，计算数字列表的总和
    public double sum(List<? extends Number> numbers) {
        double total = 0;
        for (Number num : numbers) {
            total += num.doubleValue(); // Number类有doubleValue()方法
        }
        return total;
    }

    public static void main(String[] args) {
        TSum tSum = new TSum();
        // 使用
        List<Integer> intList = Arrays.asList(1, 2, 3);
        List<Double> doubleList = Arrays.asList(1.1, 2.2, 3.3);

        double sum1 = tSum.sum(intList);    // 可以，Integer extends Number
        double sum2 = tSum.sum(doubleList); // 可以，Double extends Number
    }

}
