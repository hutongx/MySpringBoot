package com.myspringboot.test.TTypeToken;

import com.myspringboot.test.TTypeToken.token.SuperTypeToken;

import java.lang.reflect.Array;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

// =================== 6. 常见问题和解决方案 ===================
class TypeTokenProblems {

    // 问题1：无法直接创建泛型数组
    public static <T> T[] createArray(Class<T> type, int size) {
        @SuppressWarnings("unchecked")
        T[] array = (T[]) Array.newInstance(type, size);
        return array;
    }

    // 问题2：复杂泛型类型的处理
    public static void analyzeParameterizedType(Type type) {
        if (type instanceof ParameterizedType) {
            ParameterizedType pt = (ParameterizedType) type;
            System.out.println("原始类型: " + pt.getRawType());
            System.out.println("类型参数: " + Arrays.toString(pt.getActualTypeArguments()));
        }
    }

    public static void main(String[] args) {
        // 演示泛型数组创建
        String[] strings = createArray(String.class, 5);
        System.out.println("创建的数组长度: " + strings.length);

        // 演示复杂类型分析
        SuperTypeToken<Map<String, List<Integer>>> complexToken =
                new SuperTypeToken<Map<String, List<Integer>>>() {};
        analyzeParameterizedType(complexToken.getType());
    }
}
