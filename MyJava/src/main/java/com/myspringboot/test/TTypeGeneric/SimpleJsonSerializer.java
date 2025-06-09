package com.myspringboot.test.TTypeGeneric;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.Map;

// =================== 4. 实际应用：简单的JSON序列化器 ===================
class SimpleJsonSerializer {

    public static String serialize(Object obj) {
        if (obj == null) return "null";

        Class<?> clazz = obj.getClass();

        // 处理基本类型
        if (clazz == String.class) {
            return "\"" + obj + "\"";
        }
        if (Number.class.isAssignableFrom(clazz) || clazz.isPrimitive()) {
            return obj.toString();
        }

        // 处理集合
        if (obj instanceof Collection) {
            Collection<?> collection = (Collection<?>) obj;
            StringBuilder sb = new StringBuilder("[");
            boolean first = true;
            for (Object item : collection) {
                if (!first) sb.append(",");
                sb.append(serialize(item));
                first = false;
            }
            sb.append("]");
            return sb.toString();
        }

        // 处理Map
        if (obj instanceof Map) {
            Map<?, ?> map = (Map<?, ?>) obj;
            StringBuilder sb = new StringBuilder("{");
            boolean first = true;
            for (Map.Entry<?, ?> entry : map.entrySet()) {
                if (!first) sb.append(",");
                sb.append(serialize(entry.getKey())).append(":")
                        .append(serialize(entry.getValue()));
                first = false;
            }
            sb.append("}");
            return sb.toString();
        }

        // 处理普通对象（简化版）
        return serializeObject(obj);
    }

    private static String serializeObject(Object obj) {
        Class<?> clazz = obj.getClass();
        StringBuilder sb = new StringBuilder("{");
        boolean first = true;

        for (Field field : clazz.getDeclaredFields()) {
            if (Modifier.isStatic(field.getModifiers())) continue;

            field.setAccessible(true);
            try {
                Object value = field.get(obj);
                if (!first) sb.append(",");
                sb.append("\"").append(field.getName()).append("\":")
                        .append(serialize(value));
                first = false;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        sb.append("}");
        return sb.toString();
    }
}
