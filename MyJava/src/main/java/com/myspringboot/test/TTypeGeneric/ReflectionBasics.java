package com.myspringboot.test.TTypeGeneric;

/**
 * 反射获取泛型信息完整指南
 *
 * 核心API：
 * - Type: 所有类型的根接口
 * - ParameterizedType: 参数化类型（如List<String>）
 * - GenericArrayType: 泛型数组类型（如T[]）
 * - WildcardType: 通配符类型（如? extends Number）
 * - TypeVariable: 类型变量（如T, K, V）
 */

import java.lang.reflect.*;
import java.util.*;

// =================== 1. 反射API基础演示 ===================
class ReflectionBasics {

    // 各种泛型字段用于测试
    private List<String> stringList;
    private Map<String, Integer> stringIntMap;
    private List<? extends Number> numberList;
    private List<? super Integer> integerList;
    private String[] stringArray;
    private List<String>[] genericArray;

    public static void analyzeField(String fieldName) {
        try {
            Field field = ReflectionBasics.class.getDeclaredField(fieldName);
            Type genericType = field.getGenericType();

            System.out.println("\n=== 分析字段: " + fieldName + " ===");
            System.out.println("泛型类型: " + genericType);
            System.out.println("类型类别: " + genericType.getClass().getSimpleName());

            // 根据不同类型进行详细分析
            analyzeType(genericType);

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public static void analyzeType(Type type) {

        if (type instanceof ParameterizedType) {
            // 参数化类型：List<String>, Map<K,V> 等
            analyzeParameterizedType((ParameterizedType) type);

        } else if (type instanceof GenericArrayType) {
            // 泛型数组类型：T[], List<String>[] 等
            analyzeGenericArrayType((GenericArrayType) type);

        } else if (type instanceof WildcardType) {
            // 通配符类型：?, ? extends T, ? super T
            analyzeWildcardType((WildcardType) type);

        } else if (type instanceof TypeVariable) {
            // 类型变量：T, K, V 等
            analyzeTypeVariable((TypeVariable<?>) type);

        } else if (type instanceof Class) {
            // 普通类型
            Class<?> clazz = (Class<?>) type;
            System.out.println("普通类型: " + clazz.getName());
        }
    }

    private static void analyzeParameterizedType(ParameterizedType pt) {
        System.out.println("  原始类型: " + pt.getRawType());
        System.out.println("  拥有者类型: " + pt.getOwnerType());

        Type[] typeArgs = pt.getActualTypeArguments();
        System.out.println("  类型参数数量: " + typeArgs.length);

        for (int i = 0; i < typeArgs.length; i++) {
            System.out.println("    参数" + i + ": " + typeArgs[i]);
            if (typeArgs[i] instanceof ParameterizedType ||
                    typeArgs[i] instanceof WildcardType) {
                System.out.println("      -> 递归分析:");
                analyzeType(typeArgs[i]);
            }
        }
    }

    private static void analyzeGenericArrayType(GenericArrayType gat) {
        System.out.println("  数组组件类型: " + gat.getGenericComponentType());
        analyzeType(gat.getGenericComponentType());
    }

    private static void analyzeWildcardType(WildcardType wt) {
        Type[] upperBounds = wt.getUpperBounds();
        Type[] lowerBounds = wt.getLowerBounds();

        System.out.println("  上界: " + Arrays.toString(upperBounds));
        System.out.println("  下界: " + Arrays.toString(lowerBounds));
    }

    private static void analyzeTypeVariable(TypeVariable<?> tv) {
        System.out.println("  变量名: " + tv.getName());
        System.out.println("  声明源: " + tv.getGenericDeclaration());
        System.out.println("  边界: " + Arrays.toString(tv.getBounds()));
    }
}