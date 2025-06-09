package com.myspringboot.test.TTypeToken.token;

// =================== 1. 基础类型令牌 ===================
public class TypeToken<T> {
    private final Class<T> type;

    // 构造函数接收Class对象
    public TypeToken(Class<T> type) {
        this.type = type;
    }

    public Class<T> getType() {
        return type;
    }
}
