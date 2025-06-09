package com.myspringboot.test.TGenericArray;

import java.lang.reflect.Array;

public class SafeGenericArray<T> {
    private Object[] array;
    private Class<T> type;

    public SafeGenericArray(Class<T> type, int size) {
        this.type = type;
        // 使用反射创建正确类型的数组
        this.array = (T[]) Array.newInstance(type, size);
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        return (T) array[index];
    }

    public void set(int index, T item) {
        array[index] = item;
    }
}