package com.myspringboot.test.TTypeToken.token;

import java.util.HashMap;
import java.util.Map;

// =================== 3. 实际应用：类型安全的容器 ===================
public class TypeSafeContainer {
    private final Map<Class<?>, Object> container = new HashMap<>();

    // 存储时指定类型
    public <T> void put(Class<T> type, T instance) {
        container.put(type, type.cast(instance));
    }

    // 获取时保证类型安全
    public <T> T get(Class<T> type) {
        return type.cast(container.get(type));
    }

    // 检查是否存在某类型
    public boolean contains(Class<?> type) {
        return container.containsKey(type);
    }
}
