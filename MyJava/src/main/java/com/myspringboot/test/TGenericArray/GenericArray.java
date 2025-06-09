package com.myspringboot.test.TGenericArray;

public class GenericArray<T> {
    private T[] array;

    public GenericArray(int size) {
        // 这样写会编译错误
        // array = new T[size]; // Cannot create a generic array of T

        // 正确的做法
        array = (T[]) new Object[size]; // 需要强制转换，会有警告
    }

    public void set(int index, T item) {
        array[index] = item;
    }

    public T get(int index) {
        return array[index];
    }
}
