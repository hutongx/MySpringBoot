package com.myspringboot.test.TTypeToken.factory;

// =================== 4. 高级应用：泛型工厂 ===================
interface GenericFactory<T> {
    T create();
    Class<T> getType();
}
