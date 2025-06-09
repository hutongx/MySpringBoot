package com.myspringboot.test;

// 基础泛型类
public class Box<T> {
    private T content;

    public void set(T content) {
        this.content = content;
    }

    public T get() {
        return content;
    }

    public static void main(String[] args) {
        // 使用
        Box<String> stringBox = new Box<>();
        stringBox.set("Hello, Generics!");
        Box<Integer> intBox = new Box<>();
        intBox.set(123);

        System.out.println(stringBox.get());
        System.out.println(intBox.get());
    }
}
