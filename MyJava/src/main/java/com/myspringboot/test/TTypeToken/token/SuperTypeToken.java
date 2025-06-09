package com.myspringboot.test.TTypeToken.token;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

// =================== 2. 超类型令牌（解决复杂泛型） ===================
public abstract class SuperTypeToken<T> {
    private final Type type;

    protected SuperTypeToken() {
        // 获取当前类的泛型超类
        Type superClass = getClass().getGenericSuperclass();
        if (superClass instanceof ParameterizedType) {
            // 获取第一个类型参数
            this.type = ((ParameterizedType) superClass).getActualTypeArguments()[0];
        } else {
            throw new RuntimeException("必须指定泛型参数");
        }
    }

    public Type getType() {
        return type;
    }

    @SuppressWarnings("unchecked")
    public Class<T> getRawType() {
        if (type instanceof Class) {
            return (Class<T>) type;
        } else if (type instanceof ParameterizedType) {
            return (Class<T>) ((ParameterizedType) type).getRawType();
        }
        throw new RuntimeException("无法获取原始类型");
    }
}
