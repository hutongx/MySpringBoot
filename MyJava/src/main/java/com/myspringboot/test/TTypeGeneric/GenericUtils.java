package com.myspringboot.test.TTypeGeneric;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Map;

// =================== 3. 实用工具类：泛型工具 ===================
class GenericUtils {

    /**
     * 获取字段的泛型参数
     */
    public static Type[] getFieldGenericTypes(Class<?> clazz, String fieldName) {
        try {
            Field field = clazz.getDeclaredField(fieldName);
            Type genericType = field.getGenericType();

            if (genericType instanceof ParameterizedType) {
                return ((ParameterizedType) genericType).getActualTypeArguments();
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return new Type[0];
    }

    /**
     * 获取类的直接泛型超类参数
     */
    public static Type[] getSuperclassGenericTypes(Class<?> clazz) {
        Type superclass = clazz.getGenericSuperclass();
        if (superclass instanceof ParameterizedType) {
            return ((ParameterizedType) superclass).getActualTypeArguments();
        }
        return new Type[0];
    }

    /**
     * 检查类型是否为某个泛型类型的实例
     */
    public static boolean isParameterizedTypeOf(Type type, Class<?> rawType) {
        if (type instanceof ParameterizedType) {
            ParameterizedType pt = (ParameterizedType) type;
            return pt.getRawType().equals(rawType);
        }
        return false;
    }

    /**
     * 提取Collection的元素类型
     */
    public static Class<?> getCollectionElementType(Type collectionType) {
        if (collectionType instanceof ParameterizedType) {
            ParameterizedType pt = (ParameterizedType) collectionType;
            if (Collection.class.isAssignableFrom((Class<?>) pt.getRawType())) {
                Type elementType = pt.getActualTypeArguments()[0];
                if (elementType instanceof Class) {
                    return (Class<?>) elementType;
                }
            }
        }
        return Object.class; // 默认返回Object
    }

    /**
     * 提取Map的Key和Value类型
     */
    public static Type[] getMapKeyValueTypes(Type mapType) {
        if (mapType instanceof ParameterizedType) {
            ParameterizedType pt = (ParameterizedType) mapType;
            if (Map.class.isAssignableFrom((Class<?>) pt.getRawType())) {
                return pt.getActualTypeArguments();
            }
        }
        return new Type[]{Object.class, Object.class};
    }
}
