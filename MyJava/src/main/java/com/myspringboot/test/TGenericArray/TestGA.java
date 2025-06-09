package com.myspringboot.test.TGenericArray;

public class TestGA {

    public static void main(String[] args) {
        // 使用
        SafeGenericArray<String> stringArray = new SafeGenericArray<>(String.class, 10);
        stringArray.set(0, "hello");
        String result = stringArray.get(0);
        System.out.println("String at index 0: " + result);

        GenericArray<String> stringGenericArray = new GenericArray<>(3);
        stringGenericArray.set(0, "str");
        System.out.println(stringGenericArray.get(0));
    }
}
