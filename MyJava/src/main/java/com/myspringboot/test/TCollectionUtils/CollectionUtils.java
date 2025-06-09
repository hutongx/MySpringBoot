package com.myspringboot.test.TCollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class CollectionUtils {
    // 创建不可变列表的便捷方法
    @SafeVarargs
    public static <T> List<T> listOf(T... elements) {
        return Arrays.asList(elements);
    }

    // 过滤集合的通用方法
    public static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        for (T item : list) {
            if (predicate.test(item)) {
                result.add(item);
            }
        }
        return result;
    }

    // 转换集合的通用方法
    public static <T, R> List<R> map(List<T> list, Function<T, R> mapper) {
        List<R> result = new ArrayList<>();
        for (T item : list) {
            result.add(mapper.apply(item));
        }
        return result;
    }
}
